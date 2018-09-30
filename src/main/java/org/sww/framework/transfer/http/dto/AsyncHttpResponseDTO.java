package org.sww.framework.transfer.http.dto;

import java.util.concurrent.Future;

public class AsyncHttpResponseDTO extends HttpResposneDTO {
	private Future<AsyncHttpResponseDTO> future;	
	
	public Future<AsyncHttpResponseDTO> getFuture() {
		return future;
	}
	public void setFuture(Future<AsyncHttpResponseDTO> future) {
		this.future = future;
	}
}
