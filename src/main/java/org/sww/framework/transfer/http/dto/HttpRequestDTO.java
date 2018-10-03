package org.sww.framework.transfer.http.dto;

import org.sww.framework.transfer.dto.InputDTO;

public class HttpRequestDTO<T> implements InputDTO<T> {

	@Override
	public void watch(InputDTO<T> currentInputDTO) {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "HttpRequestDTO [toString()=" + super.toString() + "]";
	}

}
