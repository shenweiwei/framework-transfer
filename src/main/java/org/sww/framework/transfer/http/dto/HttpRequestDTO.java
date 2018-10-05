package org.sww.framework.transfer.http.dto;

import org.sww.framework.transfer.dto.InputDTO;

public class HttpRequestDTO implements InputDTO {

	@Override
	public void watch(InputDTO currentInputDTO) {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "HttpRequestDTO [toString()=" + super.toString() + "]";
	}

}
