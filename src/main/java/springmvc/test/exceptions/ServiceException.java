package springmvc.test.exceptions;

public class ServiceException extends RuntimeException{

	/**
	 * ServiceException:所有服务类运行时异常
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException(String message) {
        super(message);
    }
    
    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }

}
