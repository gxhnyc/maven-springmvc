package springmvc.test.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;

import springmvc.test.pojo.Publisher;

public interface PublisherService {

	//void add();
	@PreAuthorize("hasAuthority('Limi_PUBLISHER_RW')")
	void create(Publisher pb);
	
	@PreAuthorize("hasAnyAuthority('Limi_PUBLISHER_RW','Limi_PUBLISHER_RO')")
	List<Publisher> listAll();
	
	@PreAuthorize("hasAnyAuthority('Limi_PUBLISHER_RW','Limi_PUBLISHER_RO')")
	Publisher findOne(Long id);
	
	@PreAuthorize("hasAuthority('Limi_PUBLISHER_RW')")
	void update(Publisher publisher);
	
	@PreAuthorize("hasAuthority('Limi_PUBLISHER_RW')")
	void delete(Long id);
	
	@PreAuthorize("hasAnyAuthority('Limi_PUBLISHER_RW','Limi_PUBLISHER_RO')")
	List<Publisher> findAllOptions();

}
