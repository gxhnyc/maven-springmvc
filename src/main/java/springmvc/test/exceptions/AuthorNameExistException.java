package springmvc.test.exceptions;

public class AuthorNameExistException extends ServiceException {

	/**
	 * 异常：作者姓名已存在！
	 */
	private static final long serialVersionUID = 1L;
	
	public AuthorNameExistException() {
		super("作者姓名已存在！");
	}
		
}


