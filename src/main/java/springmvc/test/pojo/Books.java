package springmvc.test.pojo;

import java.util.ArrayList;
import java.util.List;

public class Books {
	private long book_id;
	private String book_name;
	private String book_brief;
	private Publisher publisher;
	private List<Author> author;
	
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
	/*@Override
	public String toString() {
		return "《"+book_name+"》";
	}*/
	
	
	
	/*@Override
	public String toString() {
		List<String> list=new ArrayList<String>();
		for(Author a:author) {
			list.add(a.getAuthor_name());
		}
		return "Books [book_id:" + book_id + ", book_name=" + book_name + ", author=" + list +  ", book_brief=" + book_brief + ", publisher="
				+ publisher.getPublisher_name()+ "]";
	}
	*/
	
	
}
