package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springmvc.test.mapper.OperatorMapper;
import springmvc.test.pojo.Operator;
import springmvc.test.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService {
	
	private OperatorMapper operatorMapper;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public OperatorServiceImpl(OperatorMapper operatorMapper, PasswordEncoder passwordEncoder) {
		super();
		this.operatorMapper = operatorMapper;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public List<Operator> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operator findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOne(Operator op) {
		String encodepwd=passwordEncoder.encode(op.getPassword());
		op.setPassword(encodepwd);
		operatorMapper.createOne(op);

	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOne(Operator op) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Operator> findByRoleAndDisabled(String role, String disabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operator> findByUsernameLike(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batchDelete(List<Long> list1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void batchDisable(List<Integer> list2, String disabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Operator> search(Operator operator) {
		// TODO Auto-generated method stub
		return null;
	}

}
