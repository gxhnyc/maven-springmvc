package springmvc.test.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Author {
	private long author_id;
	
	@Size(min=1,max=512,message="名字必填,1-512字")
	private String author_name;
	
	@NotNull(message="必填")
	private AuthorGender author_gender;
	
	@Size(min=1,max=1024)	
	private String author_brief;
	
	private List<Books> books;
	public long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public AuthorGender getAuthor_gender() {
		return author_gender;
	}
	public void setAuthor_gender(AuthorGender author_gender) {
		this.author_gender = author_gender;
	}

	public String getAuthor_brief() {
		return author_brief;
	}
	public void setAuthor_brief(String author_brief) {
		this.author_brief = author_brief;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		List<String> list=new ArrayList<String>();
		for(Books b:books) {
			list.add("《"+b.getBook_name()+"》");
		}
		
		return "Author {author_id=" + author_id + ", 作者：" + author_name + ", 性别：" + author_gender
				+ ", 作者简介：" + author_brief + ", 编写书籍：" + list + "}";
	}
		
	
	
}
