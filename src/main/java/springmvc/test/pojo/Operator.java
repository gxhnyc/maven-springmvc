package springmvc.test.pojo;

public class Operator {
	
	private Integer id;//-id: Integer
	private String username;// -username: String
	private String password;//  -password: String
	private String role;//  -role: String
	private String disabled;//  -disabled: Boolean
	
	 
	/*
	 * 构造器
	 */
	public Operator() {}
	public Operator(Integer id, String username, String password, String role, String disabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.disabled = disabled;
	}
	@Override
	public String toString() {
		return "Operator [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", disabled=" + disabled + "]";
	}
	
	/*
	 * getters  setters
	 */
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	 
	

}
