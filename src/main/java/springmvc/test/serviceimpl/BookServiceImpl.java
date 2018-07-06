package springmvc.test.serviceimpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.test.mapper.BooksMapper;
import springmvc.test.pojo.Author;
import springmvc.test.pojo.Books;
import springmvc.test.service.BookService;

@Service
@Transactional//开启事务应用服务
public class BookServiceImpl implements BookService {
	private BooksMapper booksMapper;
	
	@Autowired
	public BookServiceImpl(BooksMapper booksMapper) {
		super();
		this.booksMapper = booksMapper;
	}

	@Override
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return booksMapper.findAll();
	}

	@Override
	public Books findOne(long id) {
		// TODO Auto-generated method stub
		return booksMapper.findOne(id);
	}

	@Override
	public void createOne(Books books) {
		//1.创建书籍：书名、简介、出版社id
		booksMapper.createOne(books);
		System.out.println("BOOK:"+books.getBook_id()+":"+books.getBook_name());
		//2.创建书籍与作者关联
		for(Author au:books.getAuthor()) {
			if(au.getAuthor_id()!=null) {
				booksMapper.addAuthor(books.getBook_id(),au.getAuthor_id());
			}
		}
		
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		booksMapper.deleteOne(id);
	}

	@Override
	public void updateOne(Books op) {
		// TODO Auto-generated method stub
		booksMapper.updateOne(op);
	}

}
