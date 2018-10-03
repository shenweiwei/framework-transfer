package org.sww.framework.transfer.http.dto;

import org.springframework.web.context.request.async.DeferredResult;
import org.sww.framework.transfer.dto.InputDTO;
import org.sww.framework.transfer.dto.OutputDTO;

public class AsyncHttpDataTransferObject<I, O> extends HttpDataTransferObject<I, O> {
	private DeferredResult<AsyncHttpResponseDTO<O>> deferredResult;
	private static final long serialVersionUID = 3976223356804953951L;

	public AsyncHttpDataTransferObject(InputDTO<I> httpRequestDTO, OutputDTO<O> httpResposneDTO) {
		super(httpRequestDTO, httpResposneDTO);
		this.setDeferredResult(new DeferredResult<AsyncHttpResponseDTO<O>>());
	}
	public DeferredResult<AsyncHttpResponseDTO<O>> getDeferredResult() {
		return deferredResult;
	}
	public void setDeferredResult(DeferredResult<AsyncHttpResponseDTO<O>> deferredResult) {
		this.deferredResult = deferredResult;
	}
}
