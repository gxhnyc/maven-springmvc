package springmvc.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.pojo.Operator;
import springmvc.test.service.OperatorService;

@Controller
public class OperatorController {
	
	private OperatorService operatorService;	
	
	@Autowired
	public OperatorController(OperatorService operatorService) {
		super();
		this.operatorService = operatorService;
		
	}

	@RequestMapping(method=RequestMethod.GET,value="/operators/operator-add")
	public String add() {
		//@RequestParam获取表单字段值，注意参数名要同字段名
		
		return "operator-add";
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/operators/operator-add")
	public String add(@RequestParam String username,@RequestParam String password) {
		//@RequestParam获取表单字段值，注意参数名要同字段名
		System.out.println("---------OperatorController-------");		
		System.out.println("添加Operator:"+username);
		Operator op=new Operator();
		op.setId(100);
		op.setUsername(username);
		op.setPassword(password);
		op.setRole("小美女");
		op.setDisabled("true");
		operatorService.createOne(op);		
		
		return "operator-add";
		
		
	}
	
	
}
