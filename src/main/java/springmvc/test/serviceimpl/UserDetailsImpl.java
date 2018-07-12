package springmvc.test.serviceimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import springmvc.test.pojo.Limits;
import springmvc.test.pojo.Operator;

public class UserDetailsImpl implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;//权限
	private boolean enabled;
	private Operator operator;
	
	
	
	
	public UserDetailsImpl(Operator operator) {
		
		this.username = operator.getUsername();
		this.password = operator.getPassword();
		this.authorities = buildAuthorities(operator);
		this.enabled = operator.getDisabled()==null?true:!operator.getDisabled();
		this.operator=operator;
	}
	/**
	 * 	e.g.
     *	ROLE_图书管理员
     *	PERM_BOOK_RO
     *	PERM_AUTHOR_RO
     *	PERM_PUBLISHER_RO
     *	将权限按以上格式设置到authorities属性中去
	 * @param operator
	 * @return
	 */
	private List<GrantedAuthority> buildAuthorities(Operator operator) {

		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + operator.getRole().getRole_name()));
		
		for(Limits li:operator.getRole().getLimits()) {
			authorities.add(new SimpleGrantedAuthority("Limi_"+li.getLimits_id()));
		}
		
		return authorities;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
	/**
	 * 账号是否没有过期
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 账号是否没有锁定
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 密码是否没有过期
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 账号是否启用
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	

	

}
