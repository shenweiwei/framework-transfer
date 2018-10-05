package org.sww.framework.transfer.http.dto ;

import org.sww.framework.transfer.dto.OutputDTO ;

public class HttpResposneDTO implements OutputDTO {
	
	private String	code ;
	private String	message ;
	
	public String getCode() {
		return code ;
	}
	
	public HttpResposneDTO setCode(String code) {
		this.code = code ;
		return this ;
	}
	
	public String getMessage() {
		return message ;
	}
	
	public HttpResposneDTO setMessage(String message) {
		this.message = message ;
		return this ;
	}
	
	public static HttpResposneDTO create() {
		return new HttpResposneDTO() ;
	}
	
	@Override
	public void watch(OutputDTO currentOutputDTO) {
		System.out.println(this.toString()) ;
	}
	
	@Override
	public String toString() {
		return "HttpResposneDTO [code=" + code + ", message=" + message + "]" ;
	}
	
}
