package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.exceptions.RoleNameExistException;
import springmvc.test.mapper.RoleMapper;
import springmvc.test.pojo.Limits;
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


	@Override
	public void create(Role role) {
		//去数据库查询角色名称，若有则返回一个大于0的整数，抛异常
		if(roleMapper.roleNameExist(role.getRole_name())>0) {
			throw new RoleNameExistException();
		}
		//创建角色
		roleMapper.create(role);
		//创建角色-权限关联
		for(Limits limit:role.getLimits()) {
			roleMapper.addLimits(role.getRole_id(),limit.getLimits_id()	);
		}
		
		
	}


	@Override
	public void deleteOne(Long id) {
		roleMapper.deleteLimits(id);
		roleMapper.deleteRole(id);
		
	}


	@Override
	public Role findOneToEdit(Long id) {
		
		//然后返回查询到的角色id,角色名，角色描述
		return roleMapper.findOneToEdit(id);
	}


	@Override
	public void update(Role ro) {
		//编辑提交时，先删除关联limits关系
		roleMapper.deleteLimits(ro.getRole_id());
		roleMapper.update(ro);
		//建立关联
		for(Limits li:ro.getLimits()) {
			roleMapper.addLimits(ro.getRole_id(),li.getLimits_id());
		}
	}

}
