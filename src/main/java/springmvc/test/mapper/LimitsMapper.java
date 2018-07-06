package springmvc.test.mapper;

import java.util.List;

import springmvc.test.pojo.Limits;



public interface LimitsMapper {
	
	/**
	 * 查找所有权限
	 * @return
	 */
	public List<Limits> findAllOptions();
}
