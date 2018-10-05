package org.sww.framework.transfer.http.dto ;

import org.springframework.web.context.request.async.DeferredResult ;
import org.sww.framework.transfer.dto.InputDTO ;
import org.sww.framework.transfer.dto.OutputDTO ;
import org.sww.framework.transfer.exception.TransferException ;

public class AsyncHttpDataTransferObject extends HttpDataTransferObject {
	
	private DeferredResult<AsyncHttpResponseDTO>	deferredResult ;
	private static final long											serialVersionUID	= 3976223356804953951L ;
	
	public AsyncHttpDataTransferObject(InputDTO httpRequestDTO, OutputDTO httpResposneDTO) {
		super(httpRequestDTO, httpResposneDTO) ;
		this.setDeferredResult(new DeferredResult<AsyncHttpResponseDTO>()) ;
	}
	
	public DeferredResult<AsyncHttpResponseDTO> getDeferredResult() {
		return deferredResult ;
	}
	
	public void setDeferredResult(DeferredResult<AsyncHttpResponseDTO> deferredResult) {
		this.deferredResult = deferredResult ;
	}
	
	public void transferFinish() {
		this.getDeferredResult().setResult((AsyncHttpResponseDTO) super.getOutputDTO()) ;
	}
	
	public void transferFailed(TransferException ex) {
		AsyncHttpResponseDTO asyncHttpResponseDTO = ((AsyncHttpResponseDTO) super.getOutputDTO());
		this.getDeferredResult().setErrorResult(asyncHttpResponseDTO.setCode(ex.getCode()).setMessage(ex.getMessage())) ;
	}
}
