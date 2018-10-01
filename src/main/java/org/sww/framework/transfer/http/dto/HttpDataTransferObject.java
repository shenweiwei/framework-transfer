package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.annotation.AsyncResult;
import org.sww.framework.transfer.dto.AbstractDTO;
import org.sww.framework.transfer.dto.InputDTO;
import org.sww.framework.transfer.dto.OutputDTO;

import io.reactivex.Observable;

public class HttpDataTransferObject extends AbstractDTO implements Serializable {
	private static final long serialVersionUID = -8072884079681809776L;
	private Observable<?> requestObservable;
	private Observable<?> responseObservable;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO)) {
			this.requestObservable = this.create(httpRequestDTO);
		}
		if (ObjectUtils.allNotNull(httpResposneDTO)) {
			this.responseObservable = this.create(httpResposneDTO);
		}
	}
	private <T> Observable<T> create(T t) {
		return Observable.create(observer -> {
			observer.onNext(t);
		});
	}

	public void transferFinish() {
		AsyncHttpResponseDTO asyncHttpResponseDTO = (AsyncHttpResponseDTO) super.getOutputDTO();
		asyncHttpResponseDTO.setFuture(new AsyncResult<AsyncHttpResponseDTO>(asyncHttpResponseDTO));
	}

	public void watch() {
		subscribeHttpDTO(this.getRequestObservable(), this.getResponseObservable());
	}

	private void subscribeHttpDTO(Observable<?>... observables) {
		for (Observable<?> observable : observables) {
			if (ObjectUtils.allNotNull(observable)) {
				observable.subscribe(dto -> {
					this.setDataAndWatchByDTOType(dto);
				});
			}
		}
	}
	
	private void setDataAndWatchByDTOType(Object dto) {
		if (dto instanceof HttpRequestDTO) {
			super.setInputDTO((HttpRequestDTO) dto);
			((HttpRequestDTO) super.getInputDTO()).watch((InputDTO) dto);
		} else if (dto instanceof HttpResposneDTO) {
			super.setOutputDTO((OutputDTO) dto);
			((HttpResposneDTO) super.getOutputDTO()).watch((OutputDTO) dto);
		}
	}
	
	public Observable<?> getRequestObservable() {
		return requestObservable;
	}
	public void setRequestObservable(Observable<?> requestObservable) {
		this.requestObservable = requestObservable;
	}
	public Observable<?> getResponseObservable() {
		return responseObservable;
	}
	public void setResponseObservable(Observable<?> responseObservable) {
		this.responseObservable = responseObservable;
	}
}
