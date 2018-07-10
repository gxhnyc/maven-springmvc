package springmvc.test.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springmvc.test.form.RoleForm;



public class Role {
	
    private Long role_id;
   @Size(min=2,max=32)
    private String role_name;
   @Size(max=128)
    private String role_desc;
    //对多
   
    private List<Limits> limits=new ArrayList<Limits>();
  
   
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
	public List<Limits> getLimits() {
		return limits;
	}
	public void setLimits(List<Limits> limits) {
		this.limits = limits;
	}
	/**
	 * 由role转换成roleForm对象
	 * @return
	 */
	public RoleForm toRoleForm() {

		RoleForm roleForm=new RoleForm();
		roleForm.setRole_id(role_id);
		roleForm.setRole_name(role_name);
		roleForm.setRole_desc(role_desc);
		
		for(Limits li:this.getLimits()) {
			roleForm.getLimitsIds().add(li.getLimits_id());
		}		
		
		return roleForm;
	}
}