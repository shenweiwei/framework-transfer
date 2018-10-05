package org.sww.framework.transfer.exception ;

public class TransferException extends RuntimeException {
	
	private static final long	serialVersionUID	= 403408793026937592L ;
	private String						code ;
	
	public TransferException() {
		super() ;
	}
	
	public TransferException(String message) {
		super(message) ;
	}
	
	public TransferException(String message, String code) {
		super(message) ;
		setCode(code) ;
	}
	
	public TransferException(String message, Throwable cause) {
		super(message, cause) ;
	}
	
	public TransferException(String message, String code, Throwable cause) {
		super(message, cause) ;
		setCode(code) ;
	}
	
	public TransferException(Throwable cause) {
		super(cause) ;
	}
	
	public String getCode() {
		return code ;
	}
	
	public void setCode(String code) {
		this.code = code ;
	}
	
	public static TransferException create(String message, String code) {
		return new TransferException(message, code) ;
	}
}
