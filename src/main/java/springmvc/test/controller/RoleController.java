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

import springmvc.test.exceptions.RoleNameExistException;
import springmvc.test.form.RoleForm;
import springmvc.test.pojo.Limits;
import springmvc.test.pojo.Role;
import springmvc.test.service.LimitsService;
import springmvc.test.service.RoleService;

@Controller
public class RoleController {

	private RoleService roleService;
	private LimitsService limitsService;
	/**
	 * 通过构造器注入RoleService，LimitsService
	 * @param roleService
	 * @param limitsService
	 */
	@Autowired
	public RoleController(RoleService roleService, LimitsService limitsService) {
		super();
		this.roleService = roleService;
		this.limitsService = limitsService;
	}
	//-----------------------------add()-------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/roles/role-add")
	public String addRole(@ModelAttribute RoleForm roleForm, Model model) {		
		preparedOptionsInAdd(model);
		return "role-edit";		
	}
	@RequestMapping(method=RequestMethod.POST,value="/roles/role-add")
	public String addRole(@ModelAttribute @Valid RoleForm roleForm,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			preparedOptionsInAdd(model);
			return "role-edit";
		}
		
		try {
			roleService.create(roleForm.toRole());
		}catch(RoleNameExistException re) {
			System.out.println(re.getMessage());
			bindingResult.rejectValue("role_name", "role_name_exists_error", "角色名已存在，请重新输入！");
			preparedOptionsInAdd(model);
			return "role-edit";
		}
		
		return "redirect:/roles/role-list";
		
	}
	//--------------list()------------------------
	@RequestMapping(method=RequestMethod.GET,value="/roles/role-list")
	public String list(@ModelAttribute Role role, Model model) {		
		List<Role> roles=roleService.findAllOptions();
		model.addAttribute("roles", roles);
		return "role-list";		
	}
	//----------------------------details()-------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/roles/role-details/{id}")
	public String details(@ModelAttribute Role role,@PathVariable Long id, Model model) {		
		Role ro=roleService.findOne(id);
		model.addAttribute("role", ro);
		return "role-details";		
	}
	//-------------------------------edit()---------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/roles/role-edit/{id}")
	public String edit(@ModelAttribute RoleForm roleForm,@PathVariable Long id, Model model) {		
		//Role ro=roleService.findOneToEdit(id);
		Role ro=roleService.findOne(id);
		System.out.println("role(get):id--"+ro.getRole_id());
		roleForm=ro.toRoleForm();
		System.out.println("roleForm(get):id--"+roleForm.getRole_id());
		model.addAttribute("roleForm", roleForm);
		preparedOptionsInAdd(model);
		return "role-edit";		
	}
	
	/**
	 * Post请求方法，value路径值内的id名必须与表单类的id名一致
	 * @param roleForm
	 * @param bindingResult
	 * @param role_id
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/roles/role-edit/{role_id}")
	public String update(@ModelAttribute @Valid RoleForm roleForm,BindingResult bindingResult,
			@PathVariable Long role_id, Model model) {		
		System.out.println("roleForm:id--"+roleForm.getRole_id());
		if(bindingResult.hasErrors()) {	
			Role ro=roleService.findOne(role_id);
			roleForm=ro.toRoleForm();
			model.addAttribute("roleForm", roleForm);
			preparedOptionsInAdd(model);
			return "role-edit";	
		}
		Role role=roleForm.toRole();
		System.out.println("role_id:"+role.getRole_id()); 
		System.out.println(role.getLimits().size());
		
		roleService.update(role);
		return "redirect:/roles/role-list";		
	}
	//----------------------------delete()-----------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/roles/role-delete/{id}")
	public String delete(@ModelAttribute Role role,@PathVariable Long id, Model model) {		
		
		roleService.deleteOne(id);
		List<Role> roles =roleService.findAllOptions();
		model.addAttribute("roles", roles);
		
		return "role-list";		
	}
	
	/**
	 * 提交表单请求前，查询出权限列表并放置到model
	 * @param model
	 */
	private void preparedOptionsInAdd(Model model) {
		
		List<Limits> limitsOptions=limitsService.findAllOptions();
		
		/*Limits limitsPlaceHolder=new Limits();
		limitsPlaceHolder.setLimits_name("--请选择权限--");
		 
		limitsOptions.add(0, limitsPlaceHolder);
		System.out.println("limitsOptions:");
		for(Limits li:limitsOptions) {
			System.out.println(li.getLimits_name());
		}		*/
		model.addAttribute("limitsOptions", limitsOptions);
	}

	
	
}
