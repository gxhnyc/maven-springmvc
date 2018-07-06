package springmvc.test.service;

import java.util.List;

import springmvc.test.pojo.Role;

public interface RoleService {
	/**
	 * 查询出所有的角色
	 * @return List<Role>
	 */
	public List<Role> findAllOptions();

	public Role findOne(Long id);
}
