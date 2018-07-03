package springmvc.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.pojo.Books;
import springmvc.test.service.BookService;

@Controller
public class BooksController {
	private BookService bookService;
	@Autowired	
	public BooksController(BookService bookService) {
		super();
		this.bookService = bookService;
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
	
	
}
