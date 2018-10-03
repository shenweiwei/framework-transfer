package org.sww.framework.transfer.http.dto;

import org.sww.framework.transfer.dto.OutputDTO;

public class HttpResposneDTO<T> implements OutputDTO<T> {
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
	public void watch(OutputDTO<T> currentOutputDTO) {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		return "HttpResposneDTO [code=" + code + ", message=" + message + "]";
	}

}
