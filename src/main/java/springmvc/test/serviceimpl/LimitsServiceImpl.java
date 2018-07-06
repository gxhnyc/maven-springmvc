package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.test.mapper.LimitsMapper;
import springmvc.test.pojo.Limits;
import springmvc.test.service.LimitsService;

@Service
public class LimitsServiceImpl implements LimitsService {
	private LimitsMapper limitsMapper;
	
	@Autowired
	public LimitsServiceImpl(LimitsMapper limitsMapper) {
		super();
		this.limitsMapper = limitsMapper;
	}

	/**
	 * 查找所有权限
	 */
	@Override
	public List<Limits> findAllOptions() {
		
		return limitsMapper.findAllOptions();
	}

}
