package springmvc.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import springmvc.test.pojo.Operator;





public interface OperatorMapper {
	// 1.查询所有Operator信息
	public List<Operator> findAll();

	// 2.查询单个Operator
	public Operator findOne(Integer id);

	// 3.创建一个Operator
	public void createOne(Operator op);

	// 4.删除一个Operator
	public void deleteOne(long id);

	// 5.修改一个Operator
	public void updateOne(Operator op);

	// 6.findByRoleAndDisabled(String role, Boolean disabled)根据角色和禁用状态查询管理员
	public List<Operator> findByRoleAndDisabled(

			@Param("role") String role, @Param("disabled") String disabled

	);

	// 7.Integer count();
	public Integer count();

	// 8.List<String> findAllRoles()
	List<String> findAllRoles();

	// 9.List<Operator> findByUsernameLike(String username)查询用户名包含关键字的管理员
	public List<Operator> findByUsernameLike(@Param("username") String username);
    
	//10.void batchDelete(List<Long> list1)批量删除管理员
	public void batchDelete(@Param("list1") List<Long> list1);
    
	//11.void batchDisable(List<Integer> ids, Boolean disabled)批量禁用或启用管理员
	public void batchDisable(@Param("list2")List<Integer> list2,@Param("disabled") String disabled);
	//12.List<Operator> search(Operator operator)  动态多条件查询
    public List<Operator> search(Operator operator);
    /**
     * 创建operator与role的关联
     */
	public void addRole();

	public Integer userNameExist(String username);
	
	
}
