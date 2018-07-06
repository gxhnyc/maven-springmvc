package springmvc.test.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Books {
	private long book_id;
	@Size(min=2,max=512)
	private String book_name;
	@Size(max=1024)
	private String book_brief;
	
	@NotNull//对一关系 
	private Publisher publisher;
	@NotNull//对多关系---------------------------------------此处有问题
	private List<Author> author=new ArrayList<Author>();
	
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
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
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	
}
