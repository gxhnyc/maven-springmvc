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

import springmvc.test.exceptions.AuthorNameExistException;
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
	 * 访问http://localhost:8080/maven-springmvc/authors/
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/")
	public String list(Model model) {
		
		System.out.println("AuthorCtroller.list()----------");
		//调用AuthorService的findAll()方法获取相关信息
		List<Author> authors=authorService.findAllAuthors();
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("authors", authors);
		return "author-list";
		
	}
	/**
	 * 详情
	 * 访问http://localhost:8080/maven-springmvc/authors/id
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/{id}")
	public String authorDetails(@PathVariable Long id,Model model) {
		
		System.out.println("AuthorCtroller.authorDetails()----------");
		//调用AuthorService的findAll()方法获取相关信息
		Author author=authorService.findInfoByID(id);
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("author",author);
		
		return "author-details";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/authors/author-add")
	public String authorAdd(Model model) {
		
		System.out.println("Authoradd()--GET------------");
		model.addAttribute("author",new Author());
		return "author-edit";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/authors/author-add")
	public String authorAdd(@ModelAttribute @Valid Author author,BindingResult bindingResult) {
		
		System.out.println("Authoradd()--POST------------");
		if(bindingResult.hasErrors()) {
			return "author-edit";
		}
	// 牢记：控制层只处理参数收集、数据校验之类的，至于处理业务的细节、步骤应该放在service层
		try {
			authorService.add(author);
		}catch(AuthorNameExistException ae) {
			System.out.println(ae.getMessage());
			
				//手动添加校验码方法
				bindingResult.rejectValue(
						"author_name", //指定校验字段
						"form.authorNameAdd.exist",//错误码，I18N（国际化）
						"用户名已存在！"//如果错误码对应的错误信息没有匹配到，则默认使用此提示消息
						);
				return "author-edit";
			
		}
		return "redirect:/authors/";
		
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
		
		return "redirect:/authors/";
		
	}*/
	/**
	 * 编辑get请求，
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/{id}/author-edit")
	public String authorEdit(@PathVariable Long id,Model model) {
		Author author=authorService.findInfoByID(id);
		model.addAttribute("author", author);
		
		return "author-edit";
		}	
	@RequestMapping(method=RequestMethod.POST,value="/authors/{author_id}/author-edit")
	// @Valid告诉springmvc需要校验Author,BindingResult参数必须紧随@Valid参数；如果省略了bindingResult参数，springmvc将直接返回400（Bad request）
	public String authorUpdate(@ModelAttribute @Valid Author author,BindingResult bindingResult) {
		
		/*把表单字段封装成表单bean（new Publisher, setName, setDescription）
		注意：表单字段名要同pojo属性名，没有字段对应属性将是默认值，不识别的字段将被忽略*/
		if(bindingResult.hasErrors()) {
			return "author-edit";
		}
		System.out.println("------authorEdit.POST------"+author.getAuthor_brief());
		 // 数据校验通过才能走service
		authorService.update(author);
		 // 重定向(302) - redirect:目标路径，注意springmvc会自动加上“协议://主机:端口/项目名”
		return "redirect:/authors/author-list";
		
	}	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/authors/{id}/author-delete")
	public String delete(@PathVariable Long id) {
		authorService.delete(id);		
		return "redirect:/authors/";
		
	}
	
	
	
}
