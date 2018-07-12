package springmvc.test.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvc.test.pojo.Author;
import springmvc.test.pojo.AuthorGender;

public interface AuthorService {
	/**
	 * 通过作者姓名查找作者性别及所著书籍
	 * @param authorname
	 */
	@PreAuthorize("hasAnyAuthority('Limi_AUTHOR_RW','Limi_AUTHOR_RO')")
	public Author findBooksByAuthorName(String authorname);
	/**
	 * 通过作者id来查找该作者所编写的书籍以及出版社等相关信息
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('Limi_AUTHOR_RW','Limi_AUTHOR_RO')")
	public Author findInfoByID(Long id);
	/**
	 * 查询数据库中所有作者的信息（包括所编写的书籍及书籍对应的出版社信息）
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('Limi_AUTHOR_RW','Limi_AUTHOR_RO')")
	public List<Author> findAllAuthors();
	@PreAuthorize("hasAuthoriry('Limi_AUTHOR_RW')")
	public void add(Author au);
	
	@PreAuthorize("hasAuthoriry('Limi_AUTHOR_RW')")
	public void delete(Long id);
	@PreAuthorize("hasAuthoriry('Limi_AUTHOR_RW')")
	public void update(Author author);
	@PreAuthorize("hasAnyAuthority('Limi_AUTHOR_RW','Limi_AUTHOR_RO')")
	public List<Author> findAllOptions();
	
}
