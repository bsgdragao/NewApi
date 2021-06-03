package one.digitalinovation.bootcamp.exceptions;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -2466371041698245727L;

	public BusinessException(String message) {
		super(message);
	}

}
