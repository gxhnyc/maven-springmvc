package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.test.mapper.RoleMapper;
import springmvc.test.pojo.Role;
import springmvc.test.service.RoleService;

@Service
@Transactional//开启事务应用服务
public class RoleServiceImpl implements RoleService {
	
	private RoleMapper roleMapper;
	
	@Autowired
	public RoleServiceImpl(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}


	@Override
	public List<Role> findAllOptions() {
		
		return roleMapper.findAllOptions();
	}


	@Override
	public Role findOne(Long id) {
		// TODO Auto-generated method stub
		return roleMapper.findOne(id);
	}

}
