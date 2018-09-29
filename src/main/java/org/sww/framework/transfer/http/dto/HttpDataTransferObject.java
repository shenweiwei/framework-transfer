package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.sww.framework.transfer.dto.AbstractDTO;
import org.sww.framework.transfer.dto.DataTransferObject;

public class HttpDataTransferObject extends AbstractDTO implements Serializable, DataTransferObject {
	private static final long serialVersionUID = -8072884079681809776L;
	private HttpRequestDTO httpRequestDTO;
	private HttpResposneDTO httpResposneDTO;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			this.httpRequestDTO = (HttpRequestDTO) httpRequestDTO;
		if (ObjectUtils.allNotNull(httpResposneDTO))
			this.httpResposneDTO = (HttpResposneDTO) httpResposneDTO;
	}
	
	public HttpRequestDTO getHttpRequestDTO() {
		return httpRequestDTO;
	}
	public void setHttpRequestDTO(HttpRequestDTO httpRequestDTO) {
		this.httpRequestDTO = httpRequestDTO;
	}
	public HttpResposneDTO getHttpResposneDTO() {
		return httpResposneDTO;
	}
	public void setHttpResposneDTO(HttpResposneDTO httpResposneDTO) {
		this.httpResposneDTO = httpResposneDTO;
	}
}
