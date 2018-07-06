package springmvc.test.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc.test.exceptions.UserNameExistException;
import springmvc.test.mapper.OperatorMapper;
import springmvc.test.pojo.Operator;
import springmvc.test.pojo.Role;
import springmvc.test.service.OperatorService;

@Service
@Transactional//开启事务应用服务
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
		return operatorMapper.findAll();
	}

	@Override
	public Operator findOne(Integer id) {
		// TODO Auto-generated method stub
		return operatorMapper.findOne(id);
	}

	@Override
	public void createOne(Operator op) {
		if(operatorMapper.userNameExist(op.getUsername())>0) {
			throw new UserNameExistException();
		}
		String encodepwd=passwordEncoder.encode(op.getPassword());
		op.setPassword(encodepwd);
		//创建operator ：o_id,username,password,role_id
		operatorMapper.createOne(op);
		
			
		

	}

	@Override
	public void deleteOne(long id) {
		operatorMapper.deleteOne(id);

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
