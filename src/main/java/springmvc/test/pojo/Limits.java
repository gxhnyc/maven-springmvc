package springmvc.test.pojo;

public class Limits {
	private String limits_id;
	private String limits_name;
	private String limits_desc;
	
	public String getLimits_id() {
		return limits_id;
	}
	public void setLimits_id(String limits_id) {
		this.limits_id = limits_id;
	}
	public String getLimits_name() {
		return limits_name;
	}
	public void setLimits_name(String limits_name) {
		this.limits_name = limits_name;
	}
	public String getLimits_desc() {
		return limits_desc;
	}
	public void setLimits_desc(String limits_desc) {
		this.limits_desc = limits_desc;
	}
	@Override
	public String toString() {
		return limits_name;
	}
	
	
	
}
