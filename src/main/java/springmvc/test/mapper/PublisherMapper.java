package springmvc.test.mapper;

import java.util.List;

import springmvc.test.pojo.Publisher;

public interface PublisherMapper {
	
	//void add();

	void create(Publisher pb);

	List<Publisher> listAll();

	Publisher findOne(Long id);

	void update(Publisher publisher);

	void delete(Long id);
}
