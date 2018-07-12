package springmvc.test.pojo;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Operator {
	
	private Integer id;//-id: Integer
	
	@Size(min=2,max=32,message="2～32个字符")
	private String username;// -username: String
	
	@Size(min=3,max=16)
	private String password;//  -password: String

	private Boolean disabled;//  -disabled: Boolean
	private String email;
	
	private Role role=new Role();//  -role: 
	
	
	public Operator () {}
	
	
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
	public Boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = Boolean.valueOf(disabled);
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		 
	/*@Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password="
				+ password + ", role=" + role.getName() + ", disabled=" + disabled + "]";
	}
	 */
	

}
