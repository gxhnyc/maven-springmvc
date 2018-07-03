package springmvc.test.serviceimpl;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.test.mapper.AuthorMapper;
import springmvc.test.pojo.Author;
import springmvc.test.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private AuthorMapper authorMapper;
	
	@Autowired	
	public AuthorServiceImpl(AuthorMapper authorMapper) {
		this.authorMapper = authorMapper;
	}

	@Override
	public List<Author> findAllAuthors() {				
		
		return authorMapper.findAllAuthors();
	}

	@Override
	public Author findBooksByAuthorName(String authorname) {
		// TODO Auto-generated method stub
		return authorMapper.findBooksByAuthorName(authorname);
	}

	@Override
	public Author findInfoByID(Long id) {
		// TODO Auto-generated method stub
		return authorMapper.findInfoByID(id);
	}

	@Override
	public void add(Author au) {
		// TODO Auto-generated method stub
		authorMapper.add(au);
	}

	@Override
	public void delete(Long id) {
		authorMapper.delete(id);
		
	}

	@Override
	public void update(@Valid Author author) {
		authorMapper.update(author);
		
	}

	@Override
	public boolean authorNameExist(String authorName) {
		// TODO Auto-generated method stub
		return authorMapper.authorNameExist(authorName);
	}

}
