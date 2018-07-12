package springmvc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	/**
	 * 首页 控制器
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String HomeIndex() {
		
		
		return "index";
		
	}
}
