package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.sww.framework.transfer.dto.AbstractDTO;
import org.sww.framework.transfer.dto.DataTransferObject;
import org.sww.framework.transfer.dto.InputDTO;
import org.sww.framework.transfer.dto.OutputDTO;

public class HttpDataTransferObject extends AbstractDTO implements Serializable, DataTransferObject {
	private static final long serialVersionUID = -8072884079681809776L;
	private InputDTO httpRequestDTO;
	private OutputDTO httpResposneDTO;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			this.httpRequestDTO = (HttpRequestDTO) httpRequestDTO;
		if (ObjectUtils.allNotNull(httpResposneDTO))
			this.httpResposneDTO = (HttpResposneDTO) httpResposneDTO;
	}

	public InputDTO getHttpRequestDTO() {
		return httpRequestDTO;
	}

	public void setHttpRequestDTO(InputDTO httpRequestDTO) {
		this.httpRequestDTO = httpRequestDTO;
	}

	public OutputDTO getHttpResposneDTO() {
		return httpResposneDTO;
	}

	public void setHttpResposneDTO(OutputDTO httpResposneDTO) {
		this.httpResposneDTO = httpResposneDTO;
	}

	
}
