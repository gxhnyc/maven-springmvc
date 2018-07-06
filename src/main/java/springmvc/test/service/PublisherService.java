package springmvc.test.service;

import java.util.List;

import javax.validation.Valid;

import springmvc.test.pojo.Publisher;

public interface PublisherService {

	//void add();

	void create(Publisher pb);

	List<Publisher> listAll();

	Publisher findOne(Long id);

	void update(Publisher publisher);

	void delete(Long id);

	List<Publisher> findAllOptions();

}
