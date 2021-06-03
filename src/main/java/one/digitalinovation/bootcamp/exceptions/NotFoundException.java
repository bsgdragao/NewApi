package one.digitalinovation.bootcamp.exceptions;

import one.digitalinovation.bootcamp.util.MessageUtils;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3490199266653947863L;
	
	public NotFoundException() {
		super (MessageUtils.NO_RECORDS_FOUND);
	}

}
