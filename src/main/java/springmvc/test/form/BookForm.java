package springmvc.test.form;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springmvc.test.pojo.Author;
import springmvc.test.pojo.Books;
import springmvc.test.pojo.Publisher;

/**
 * 用于替代pojo-Books
 * 接收jsp表单上的数据（book_name,book_brief,publisher_id）
 * toBook()方法，转换成Books
 * @author Administrator
 *
 */
public class BookForm {
	@Size(min=1,max=64)
	private String book_name;
	@Size(max=1024)
	private String book_brief;
	@NotNull(message="必选")
	private Long publisher_id;
	@Size(min=1,message="必选")
	private List<Long> author_ids;
	//-----------------------------------------
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_brief() {
		return book_brief;
	}
	public void setBook_brief(String book_brief) {
		this.book_brief = book_brief;
	}
	public Long getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}
	public List<Long> getAuthor_ids() {
		return author_ids;
	}
	public void setAuthor_ids(List<Long> author_ids) {
		this.author_ids = author_ids;
	}
	
	//--------------------------------------------
	public Books toBooks() {
		Books books=new Books();
		books.setBook_name(book_name);
		books.setBook_brief(book_brief);
		
		Publisher publisher=new Publisher();
		publisher.setPublisher_id(publisher_id);
		
		books.setPublisher(publisher);	
		
		for(Long author_id:author_ids) {
			Author author=new Author();
			author.setAuthor_id(author_id);
			books.getAuthor().add(author);
		}
		
		return books;
		
	}
	
}
