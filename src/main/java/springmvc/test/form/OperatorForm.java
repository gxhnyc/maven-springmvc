package springmvc.test.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springmvc.test.pojo.Limits;
import springmvc.test.pojo.Operator;
import springmvc.test.pojo.Role;

public class OperatorForm {
	
	private Integer id;//-id: Integer
	@Size(min=2,max=32,message="2～32个字符")
	private String username;// -username: String
	@Size(min=3,max=16)
	private String password;//  -password: String

	private String disabled;//  -disabled: Boolean
	@NotNull
	private Long role_id;//  -role: 
	@NotNull
	private List<String> limitsIds=new ArrayList<String>();
	//------------------------------------------------------------
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public List<String> getLimitsIds() {
		return limitsIds;
	}
	public void setLimitsIds(List<String> limitsIds) {
		this.limitsIds = limitsIds;
	}
	//-----------------------------------------------------------
	
	public Operator toOperator() {
		Operator operator=new Operator();
		
		operator.setUsername(username);
		operator.setPassword(password);
		
		Role role=new Role();
		role.setRole_id(role_id);		
		
		for(String limitid:limitsIds) {
			Limits limit=new Limits();
			limit.setLimits_id(limitid);
			role.getLimits().add(limit);
		}		
		operator.setRole(role);
				
		return operator;
		
	}
	
}
