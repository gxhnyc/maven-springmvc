package springmvc.test.mapper;

import java.util.List;

import springmvc.test.pojo.Author;




public interface AuthorMapper {
	/**
	 * 通过作者姓名查找作者性别及所著书籍
	 * @param authorname
	 */
	public Author findBooksByAuthorName(String authorname);
	/**
	 * 通过作者id来查找该作者所编写的书籍以及出版社等相关信息
	 * @return
	 */
	public Author findInfoByID(Long id);
	/**
	 * 查询数据库中所有作者的信息（包括所编写的书籍及书籍对应的出版社信息）
	 * @return
	 */
	public List<Author> findAllAuthors();
	public void add(Author au);
	public void delete(Long id);
	public void update(Author author);
	public boolean authorNameExist(String authorName);
	public List<Author> findAllOptions();
	/**
	 * 删除bookauthor关联
	 * @param id
	 */
	public void deleteBA(Long id);
}
