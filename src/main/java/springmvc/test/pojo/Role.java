package springmvc.test.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Role {
    private Long role_id;
    @Size(min=1,max=32)
    private String role_name;
    @Size(max=512)
    private String role_desc;
    //对多
    @NotNull
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
}