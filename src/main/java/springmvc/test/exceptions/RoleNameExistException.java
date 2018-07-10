package springmvc.test.exceptions;

public class RoleNameExistException extends ServiceException {
	
	/**
	 * 角色名已存在，抛异常
	 */
	private static final long serialVersionUID = 1L;

	public RoleNameExistException() {
		super("角色名已存在！");
	}
}
