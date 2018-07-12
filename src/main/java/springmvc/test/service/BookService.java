package springmvc.test.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvc.test.pojo.Books;

public interface BookService {
	/**
	 *  1.查询所有Book信息
	 * @return
	 */
	@PreAuthorize("hasAnyAuthority('Limi_BOOK_RW','Limi_BOOK_RO')")
	public List<Books> findAll();

	/**
	 *  2.通过书籍id查找书籍相关信息及出版社名
	 * @param id
	 * @return Books
	 */
	@PreAuthorize("hasAnyAuthority('Limi_BOOK_RW','Limi_BOOK_RO')")
	public Books findOne(long id);

	/**
	 * 3.创建一个Book
	 * @param op
	 */
	@PreAuthorize("hasAuthority('Limi_BOOK_RW')")
	public void createOne(Books op);

	/**
	 *  4.删除一个Book
	 * @param id
	 */
	@PreAuthorize("hasAuthority('Limi_BOOK_RW')")
	public void deleteOne(long id);

	/**
	 *  5.修改一个Book
	 * @param op
	 */
	@PreAuthorize("hasAuthority('Limi_BOOK_RW')")
	public void updateOne(Books op);

}
