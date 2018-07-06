package springmvc.test.mapper;

import java.util.List;

import springmvc.test.pojo.Role;

public interface RoleMapper {
	/**
	 * 查询所有的角色role
	 * @return
	 */
	public  List<Role> findAllOptions();

	public Role findOne(Long id);
}
