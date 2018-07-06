package springmvc.test.pojo;


import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Publisher {
	//@NotNull(message="不能为空且不能重复！")
	private Long publisher_id;
	@Size(min=1,max=512,message="名字范围:2-512字")
	private String publisher_name;
	@Size(min=2,max=1024,message="简介范围:不超过1024字")
	private String publisher_brief;
	private List<Books> books;
	
	
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public String getPublisher_brief() {
		return publisher_brief;
	}
	public void setPublisher_brief(String publisher_brief) {
		this.publisher_brief = publisher_brief;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public Long getPublisher_id() {
		return publisher_id;
	}
	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}
		
	
	
}
