package springmvc.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.pojo.Author;
import springmvc.test.service.AuthorService;

@Controller
public class AuthorController {
	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService author) {
		
		this.authorService = author;
	}
	/**
	 * 访问http://localhost:8080/maven-springmvc/authors/author-list
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/author-list")
	public String list(Model model) {
		
		System.out.println("AuthorCtroller.list()----------");
		//调用AuthorService的findAll()方法获取相关信息
		List<Author> authors=authorService.findAllAuthors();
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("authors",authors);
		
		return "author-list";
		
	}
	/**
	 * 访问http://localhost:8080/maven-springmvc/authors/author-details/id
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/author-details/{id}")
	public String authorDetails(@PathVariable Long id,Model model) {
		
		System.out.println("AuthorCtroller.authorDetails()----------");
		//调用AuthorService的findAll()方法获取相关信息
		Author author=authorService.findInfoByID(id);
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("author",author);
		
		return "author-details";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/authors/author-add")
	public String authoradd(Model model) {
		
		System.out.println("Authoradd()--GET------------");
		model.addAttribute("author",new Author());
		return "author-add";
		
	}
	
	/*@RequestMapping(method=RequestMethod.POST,value="/authors/author-add")
	public String authoradd( @RequestParam String author_name,
							  @RequestParam String author_gender,
							  @RequestParam String author_brief	) {
		Author au=new Author();
		au.setAuthor_name(author_name);
		au.setAuthor_gender(author_gender);
		au.setAuthor_brief(author_brief);
		authorService.add(au);
		
		return "redirect:/authors/author-list";
		
	}*/
	@RequestMapping(method=RequestMethod.POST,value="/authors/author-add")
	// @Valid告诉springmvc需要校验Author,BindingResult参数必须紧随@Valid参数；如果省略了bindingResult参数，springmvc将直接返回400（Bad request）
	public String authoradd(@Valid Author author,BindingResult bindingResult,Model model	) {
		/*把表单字段封装成表单bean（new Publisher, setName, setDescription）
		注意：表单字段名要同pojo属性名，没有字段对应属性将是默认值，不识别的字段将被忽略*/
		if(bindingResult.hasErrors()) {
			model.addAttribute("author", author);
			return "author-add";
		}
		 // 数据校验通过才能走service
		authorService.add(author);
		 // 重定向(302) - redirect:目标路径，注意springmvc会自动加上“协议://主机:端口/项目名”
		return "redirect:/authors/author-list";
		
	}
	
	
	
}
