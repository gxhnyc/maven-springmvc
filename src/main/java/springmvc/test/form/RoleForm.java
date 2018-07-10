package springmvc.test.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import springmvc.test.pojo.Limits;
import springmvc.test.pojo.Role;

public class RoleForm {
	private Long role_id;
	@Size(min=1,max=32)
	private String role_name;
	@Size(max=128)
	private String role_desc;
	
	private List<String> limitsIds=new ArrayList<String>();
	
	//--------------------------------getters+setters---------------------------------
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public List<String> getLimitsIds() {
		return limitsIds;
	}

	public void setLimitsIds(List<String> limitsIds) {
		this.limitsIds = limitsIds;
	}

	
	//-----------------------toRole()---------------------------------
	public Role toRole() {
		Role role=new Role();
		
		role.setRole_id(this.role_id);
		role.setRole_name(this.role_name);
		role.setRole_desc(this.role_desc);
		
		for(String id:this.limitsIds) {
			System.out.println("-----"+id);
			Limits limit=new Limits();
			limit.setLimits_id(id);
			role.getLimits().add(limit);			
		}		
		return role;
	}

	

	
}
