package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.sww.framework.transfer.dto.AbstractDTO;
import org.sww.framework.transfer.dto.DataTransferObject;
import org.sww.framework.transfer.dto.RequestDTO;
import org.sww.framework.transfer.dto.ResponseDTO;

public class HttpDataTransferObject extends AbstractDTO implements Serializable, DataTransferObject {
	private static final long serialVersionUID = -8072884079681809776L;
	private RequestDTO httpRequestDTO;
	private ResponseDTO httpResposneDTO;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			this.httpRequestDTO = (HttpRequestDTO) httpRequestDTO;
		if (ObjectUtils.allNotNull(httpResposneDTO))
			this.httpResposneDTO = (HttpResposneDTO) httpResposneDTO;
	}

	public RequestDTO getHttpRequestDTO() {
		return httpRequestDTO;
	}

	public void setHttpRequestDTO(RequestDTO httpRequestDTO) {
		this.httpRequestDTO = httpRequestDTO;
	}

	public ResponseDTO getHttpResposneDTO() {
		return httpResposneDTO;
	}

	public void setHttpResposneDTO(ResponseDTO httpResposneDTO) {
		this.httpResposneDTO = httpResposneDTO;
	}

	
}
