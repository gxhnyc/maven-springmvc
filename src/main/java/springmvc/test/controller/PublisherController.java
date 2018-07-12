package springmvc.test.controller;

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

import springmvc.test.pojo.Publisher;
import springmvc.test.service.PublisherService;

@Controller
public class PublisherController {
	
	private PublisherService publisherService;
	@Autowired
	public PublisherController(PublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}
	
	/*1、控制器 PublisherController
	  +String add()
	    映射 GET /publishers/add
	    返回 "publisher-add"
	  +String create(@RequestParam String name, @RequestParam String description)
	    映射 POST /publishers/add
	    调用 PublisherService.create(publisher)
	    返回 "publisher-add"*/
	/**
	 * 首次请求使用get请求
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/publishers/publisher-add")
	public String add(@ModelAttribute Publisher publisher/*Model model*/) {
		System.out.println("----PublisherController.add()------");
		//model.addAttribute("publisher", new Publisher());
		return "publisher-edit";		
	}
	/**
	 * 添加publisher并校验，校验成功则返回至publisher-list.jsp页面
	 * 否则，继续校验
	 * @param publisher
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST,value="/publishers/publisher-add")
	public String create(@ModelAttribute @Valid Publisher publisher,BindingResult bindingResult/*,Model model*/) {
		System.out.println("----PublisherController.create()------");
		if(bindingResult.hasErrors()) {
			//model.addAttribute("publisher", publisher);
			return "publisher-edit";
		}
		publisherService.create(publisher);
		return "redirect:/publishers/";
		
	}
	
	

	/**
	 * 列出所有publisher（含所有信息）
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/publishers/")
	public String listall(Model model) {
		System.out.println("-----PublisherController.listall()---------");
		List<Publisher> publishers=publisherService.listAll();
		model.addAttribute("publishers", publishers);
		return "publisher-list";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/publishers/{id}/edit")
	public String edit(@PathVariable Long id,Model model) {
		
		Publisher publisher=publisherService.findOne(id);
		System.out.println("get--edit--service.findOne()--"+publisher.getPublisher_name());
		model.addAttribute("publisher", publisher);
		return "publisher-edit";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/publishers/{id}/edit")
	public String update(@ModelAttribute @Valid Publisher publisher,BindingResult bindingResult) {
		System.out.println("----edit.post------"+publisher.getPublisher_id());
		if(bindingResult.hasErrors()) {
			return "publisher-edit";
		}
		publisherService.update(publisher);
		return "redirect:/publishers/publisher-list";
		}
	@RequestMapping(method=RequestMethod.GET,value="/publishers/{id}/delete")
	public String delete(@PathVariable Long id,Model model) {
		
		publisherService.delete(id);
		List<Publisher> publishers=publisherService.listAll();
		model.addAttribute("publishers", publishers);
		return "publisher-list";
		
	}
	
	/*@RequestMapping(method=RequestMethod.POST,value="/publishers/add")
	public String create(@RequestParam String publisher_name,@RequestParam String publisher_brief ) {
		System.out.println("----PublisherController.create()------");
		Publisher pb=new Publisher();
		pb.setPublisher_id(1004L);
		pb.setPublisher_name(publisher_name);
		pb.setPublisher_brief(publisher_brief);
		System.out.println(publisher_name+":"+publisher_brief);
		publisherService.create(pb);
		return "redirect:/publishers/publisher-details";
		
	}*/
	
	
	
	
}
