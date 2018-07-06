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

import springmvc.test.form.BookForm;
import springmvc.test.pojo.Author;
import springmvc.test.pojo.Books;
import springmvc.test.pojo.Publisher;
import springmvc.test.service.AuthorService;
import springmvc.test.service.BookService;
import springmvc.test.service.PublisherService;

@Controller
public class BooksController {
	private BookService bookService;
	private AuthorService authorService;
	private PublisherService publisherService;
	
	
	@Autowired	
	public BooksController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
		super();
		this.bookService = bookService;
		this.authorService = authorService;
		this.publisherService = publisherService;
	}
	
	/**
	 * 访问：http://localhost:8080/maven-springmvc/books/book-list
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/books/book-list")
	public String list(Model model) {
		
		System.out.println("BookCtroller.list()----------");
		//调用AuthorService的findAll()方法获取相关信息
		List<Books> books=bookService.findAll();
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("books",books);
		
		return "book-list";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/books/book-list")
	public String listall(Model model) {
		
		System.out.println("BookCtroller.list()----------");
		//调用AuthorService的findAll()方法获取相关信息
		List<Books> books=bookService.findAll();
		// 把数据放到model（请求域）中以便jsp获取
		model.addAttribute("books",books);
		
		return "book-list";
		
	}
	/**
	 * 访问：http://localhost:8080/maven-springmvc/books/book-details/#{id}
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/books/book-details/{id}")
	public String BookDetails(@PathVariable Long id,Model model) {
		
		System.out.println("BookCtroller.BookDetails()----------");
		//调用bookService的findOne()方法，获取图书信息
		Books book=bookService.findOne(id); 
		//把数据放到model（请求域）中以便jsp获取
		model.addAttribute("book",book);
		
		//返回需要拼接的字符串
		return "book-details";
		
	}
	//-------------------------------------------book-add-----------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/books/book-add")
	public String add(@ModelAttribute BookForm bookForm,Model model) {		
		System.out.println("BookCtroller.addBook(get)----------");	
		 prepareOptionsInAdd(model);
		return "book-add";
		}
	@RequestMapping(method=RequestMethod.POST,value="/books/book-add")
	public String addBook(@ModelAttribute @Valid BookForm bookForm,BindingResult bindingResult,Model model) {		
		System.out.println("BookCtroller.addBook(post)----------");		
		 
		if(bindingResult.hasErrors()) {
			prepareOptionsInAdd(model);
			return "book-add";
		}
		System.out.println(bookForm.getBook_name()+":"+bookForm.getBook_brief()+":#"+bookForm.getPublisher_id());
		System.out.println("作者个数："+bookForm.getAuthor_ids().size());
		
		bookService.createOne(bookForm.toBooks());
		
		return "redirect:/books/book-list";
		}
	
	
	
	
	//----------------------------------------------------------------------------
	 private void prepareOptionsInAdd(Model model) {
	        List<Author> authorsOptions = authorService.findAllOptions();
		    List<Publisher> publisherOptions = publisherService.findAllOptions();
		    
		   /* Author authorPlaceholder = new Author();
		    authorPlaceholder.setAuthor_name("--请选择作者--");
		    authorsOptions.add(0, authorPlaceholder);
		    
		    Publisher publisherPlaceholder = new Publisher();
		    publisherPlaceholder.setPublisher_name("--请选择出版社--");
		    publisherOptions.add(0, publisherPlaceholder);*/
		    
		    model.addAttribute("authorsOptions", authorsOptions);
		    model.addAttribute("publisherOptions", publisherOptions);
	    }
	
}
