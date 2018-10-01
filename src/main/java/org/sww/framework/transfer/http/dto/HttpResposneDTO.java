package org.sww.framework.transfer.http.dto;

import org.sww.framework.transfer.dto.OutputDTO;

public class HttpResposneDTO implements OutputDTO {
	private String code;
	private String message;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public void watch(OutputDTO currentOutputDTO) {
		System.out.println(222222);
		
	}

}
