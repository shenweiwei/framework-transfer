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
	private boolean isWatch;

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			super.setInputDTO((InputDTO) httpRequestDTO);
		if (ObjectUtils.allNotNull(httpResposneDTO))
			super.setOutputDTO((OutputDTO) httpResposneDTO);
	}
	public void transferFinish() {
		AsyncHttpResponseDTO asyncHttpResponseDTO = (AsyncHttpResponseDTO) super.getOutputDTO();
		asyncHttpResponseDTO.setFuture(new AsyncResult<AsyncHttpResponseDTO>(asyncHttpResponseDTO));
	}
	private void subscribe(Observable<?>... observables) {
		for (Observable<?> observable : observables) {
			if (ObjectUtils.allNotNull(observable)) {
				observable.subscribe(dto -> {
					this.onWatch(dto);
				});
			}
		}
	}
	public void onWatch(Object dto) {
		if (dto instanceof InputDTO) {
			InputDTO inputDTO = (InputDTO) dto;
			inputDTO.watch(inputDTO);
		} else if (dto instanceof OutputDTO) {
			OutputDTO outputDTO = (OutputDTO) dto;
			outputDTO.watch(outputDTO);
		}
	}
	public boolean isWatch() {
		return isWatch;
	}
	public void setWatch(boolean isWatch) {
		this.isWatch = isWatch;
		if (this.isWatch)
			this.subscribe(super.getInputObservable(), super.getOutputObservable());
	}
}
