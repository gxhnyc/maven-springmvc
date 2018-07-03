package springmvc.test.mapper;

import java.util.List;

import springmvc.test.pojo.Books;


public interface BooksMapper {
	/**
	 *  1.查询所有Book信息
	 * @return
	 */
	public List<Books> findAll();

	/**
	 *  2.通过书籍id查找书籍相关信息及出版社名
	 * @param id
	 * @return Books
	 */
	public Books findOne(long id);

	/**
	 * 3.创建一个Book
	 * @param op
	 */
	public void createOne(Books op);

	/**
	 *  4.删除一个Book
	 * @param id
	 */
	public void deleteOne(long id);

	/**
	 *  5.修改一个Book
	 * @param op
	 */
	public void updateOne(Books op);

	
	
}
