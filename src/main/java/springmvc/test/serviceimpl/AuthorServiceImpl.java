package springmvc.test.serviceimpl;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.test.exceptions.AuthorNameExistException;
import springmvc.test.mapper.AuthorMapper;
import springmvc.test.pojo.Author;
import springmvc.test.pojo.AuthorGender;
import springmvc.test.service.AuthorService;

@Service
@Transactional//开启事务应用服务
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
		if(authorMapper.authorNameExist(au.getAuthor_name())) {			
			throw new AuthorNameExistException();
		}		
		authorMapper.add(au);
	}
	@Override
	public void delete(Long id) {
		authorMapper.delete(id);
		
	}
	@Override
	public void update(Author author) {
		System.out.println("authorSerivceImpl----"+author.getAuthor_name()+"---"+author.getAuthor_brief()+"id:"+author.getAuthor_id());
		authorMapper.update(author);
		
	}
	@Override
	public List<Author> findAllOptions() {
		// TODO Auto-generated method stub
		return authorMapper.findAllOptions();
	}

}
