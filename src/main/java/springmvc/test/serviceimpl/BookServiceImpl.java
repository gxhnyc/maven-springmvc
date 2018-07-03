package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.test.mapper.BooksMapper;
import springmvc.test.pojo.Books;
import springmvc.test.service.BookService;

@Service
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
	public void createOne(Books op) {
		// TODO Auto-generated method stub
		booksMapper.createOne(op);
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
