package springmvc.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.test.pojo.Role;

public interface RoleMapper {
	/**
	 * 查询所有的角色role
	 * @return
	 */
	public  List<Role> findAllOptions();

	public Role findOne(Long id);

	public void create(Role role);

	public void addLimits(@Param ("role_id")Long role_id,@Param ("limits_id")String limits_id);

	public int roleNameExist(String role_name);

	public void deleteLimits(Long id);

	public void deleteRole(Long id);

	public Role findOneToEdit(Long id);

	public void update(Role ro);
}
