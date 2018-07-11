package springmvc.test.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.exceptions.UserNameExistException;
import springmvc.test.form.OperatorForm;
import springmvc.test.pojo.Limits;
import springmvc.test.pojo.Operator;
import springmvc.test.pojo.Role;
import springmvc.test.service.LimitsService;
import springmvc.test.service.OperatorService;
import springmvc.test.service.RoleService;

@Controller
public class OperatorController {
	
	private OperatorService operatorService;
	private RoleService roleService;
	private LimitsService limitsService;
	
	@Autowired
	public OperatorController(OperatorService operatorService, RoleService roleService, LimitsService limitsService) {
		super();
		this.operatorService = operatorService;
		this.roleService = roleService;
		this.limitsService = limitsService;
	}





//-------------------------------------operator-add-start--------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/operators/operator-add")
	public String add(@ModelAttribute OperatorForm operatorForm,Model model) {
		System.out.println("OperatorCtroller.addOperator(get)----------");
		System.out.println("operator:"+operatorForm.getUsername());
		 prepareOptionsInAdd(model);		 
		return "operator-add";		
	}	

	@RequestMapping(method=RequestMethod.POST,value="/operators/operator-add")
	public String addOperator(@ModelAttribute @Valid OperatorForm operatorForm,BindingResult bindingResult,Model model) {
		//System.out.println("operator:"+operatorForm.getUsername());
		
		/*if(operatorForm.getRole_id()==null) {
			//手动添加错误提示
			 bindingResult.rejectValue("role_id", "required", "必填");
			 prepareOptionsInAdd(model);
			 return "operator-add";
		}		*/
		if(bindingResult.hasErrors()) {
			 prepareOptionsInAdd(model);
			 return "operator-add";
		}
		
		
		
		/*System.out.println("---------OperatorController.addOperator(post)-------roleid:"+operatorForm.getRole_id());		
		System.out.println("角色id:"+operatorForm.getRole_id());*/
		
		try {
		operatorService.createOne(operatorForm.toOperator());
		}catch(UserNameExistException ue) {
			System.out.println(ue.getMessage());
			//手动添加错误
			bindingResult.rejectValue("username", "form.addOperator.usernameExist", "用户名已存在！");
			prepareOptionsInAdd(model);
			return "operator-add";
		}
		
		return "redirect:/operators/operator-list";		
	}
//-------------------------------------operator-add-end--------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/operators/operator-delete/{id}")
	public String delete(@PathVariable Long id) {
		
		operatorService.deleteOne(id);
		
		return "redirect:/operators/operator-list";	
		
	}
	
	
//-------------------------------------operator-list--------------------------------------
	/**
	 * list只有get请求，没有post请求
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/operators/operator-list")
	public String list(Model model) {
		List<Operator> operators=operatorService.findAll();
		model.addAttribute("operators", operators);		
		return "operator-list";		
	}
//-------------------------------------operator-details--------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/operators/operator-details/{id}")
	public String details(@PathVariable Integer id,Model model) {
		Operator op=operatorService.findOne(id);
		model.addAttribute("operator", op);
		
		return "operator-details";
		
	}
	
//-------------------------------------operator-list-end--------------------------------------
	
	
	/**
	 * 执行operator-add操作前的准备工作（设置选择角色列表）
	 * @param model
	 */
	private void prepareOptionsInAdd(Model model) {
		
		List<Role> roleOptions=roleService.findAllOptions();		
		List<Limits> limitsOptions=limitsService.findAllOptions();
		
		Role rolePlaceHolder=new Role();
		rolePlaceHolder.setRole_name("--请选择角色--");
		roleOptions.add(0, rolePlaceHolder);
		
		Limits limitsPlaceHolder=new Limits();
		limitsPlaceHolder.setLimits_name("--请选择权限--");
		limitsOptions.add(0, limitsPlaceHolder);
		model.addAttribute("roleOptions",roleOptions);
		model.addAttribute("limitsOptions", limitsOptions);		
	}
	
}
