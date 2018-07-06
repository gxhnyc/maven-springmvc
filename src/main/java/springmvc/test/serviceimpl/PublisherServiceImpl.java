package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.test.mapper.PublisherMapper;
import springmvc.test.pojo.Publisher;
import springmvc.test.service.PublisherService;

@Service
@Transactional//开启事务应用服务
public class PublisherServiceImpl implements PublisherService {
	private PublisherMapper publisherMapper;
	
	
	@Autowired
	public PublisherServiceImpl(PublisherMapper publisherMapper) {
		super();
		this.publisherMapper = publisherMapper;
	}

	

	@Override
	public void create(Publisher pb) {
		publisherMapper.create(pb);

	}



	@Override
	public List<Publisher> listAll() {
		// TODO Auto-generated method stub
		return publisherMapper.listAll();
	}



	@Override
	public Publisher findOne(Long id) {
		// TODO Auto-generated method stub
		return publisherMapper.findOne(id);
	}



	@Override
	public void update(Publisher publisher) {
		publisherMapper.update(publisher);
		
	}



	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		publisherMapper.delete(id);
	}



	@Override
	public List<Publisher> findAllOptions() {
		// TODO Auto-generated method stub
		return publisherMapper.findAllOptions();
	}

}
