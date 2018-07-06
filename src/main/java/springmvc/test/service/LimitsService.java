package springmvc.test.service;

import java.util.List;

import springmvc.test.pojo.Limits;

public interface LimitsService {
	/**
	 * 查找所有权限
	 * @return
	 */
	public List<Limits> findAllOptions();
}
