package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.sww.framework.transfer.dto.AbstractDTO;

public class HttpDataTransferObject extends AbstractDTO implements Serializable {
	private static final long serialVersionUID = -8072884079681809776L;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			super.setInputDTO((HttpRequestDTO) httpRequestDTO);
		if (ObjectUtils.allNotNull(httpResposneDTO))
			super.setOutputDTO((HttpResposneDTO) httpResposneDTO);
	}
	
}
