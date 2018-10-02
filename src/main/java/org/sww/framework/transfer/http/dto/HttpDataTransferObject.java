package org.sww.framework.transfer.http.dto;

import java.io.Serializable;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.annotation.AsyncResult;
import org.sww.framework.transfer.dto.AbstractDTO;
import org.sww.framework.transfer.dto.InputDTO;
import org.sww.framework.transfer.dto.OutputDTO;
import org.sww.framework.transfer.http.plugin.HttpWatcher;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HttpDataTransferObject extends AbstractDTO implements HttpWatcher, Serializable {
	private static final long serialVersionUID = -8072884079681809776L;
	private boolean isInputWatch;
	private boolean isOutputWatch;
	private PublishSubject<Object> watchSubject = PublishSubject.create();

	public HttpDataTransferObject(Object httpRequestDTO, Object httpResposneDTO) {
		if (ObjectUtils.allNotNull(httpRequestDTO))
			super.setInputDTO((InputDTO) httpRequestDTO);
		if (ObjectUtils.allNotNull(httpResposneDTO))
			super.setOutputDTO((OutputDTO) httpResposneDTO);
		this.watchSubscribe();
	}
	public void transferFinish() throws Exception {
		AsyncHttpResponseDTO asyncHttpResponseDTO = (AsyncHttpResponseDTO) super.getOutputDTO();
		asyncHttpResponseDTO.setFuture(new AsyncResult<AsyncHttpResponseDTO>(asyncHttpResponseDTO));
	}
	@Override
	public void onWatch(Object dto) {
		if (isInputWatch && dto instanceof InputDTO) {
			InputDTO inputDTO = (InputDTO) dto;
			inputDTO.watch(inputDTO);
		}
		if (isOutputWatch && dto instanceof OutputDTO) {
			OutputDTO outputDTO = (OutputDTO) dto;
			outputDTO.watch(outputDTO);
		}
	}
	@Override
	public Observable<Object> doOnNext() {
		return watchSubject.doOnNext(dto -> {
			this.setHttpDTO(dto);
		});
	}
	private void setHttpDTO(Object dto) {
		if (dto instanceof InputDTO)
			super.setInputDTO((InputDTO) dto);
		if (dto instanceof OutputDTO)
			super.setOutputDTO((OutputDTO) dto);
	}
	public boolean isInputWatch() {
		return isInputWatch;
	}
	public void setInputWatch(boolean isInputWatch) {
		this.isInputWatch = isInputWatch;
		this.setInputDTO(super.getInputDTO());
	}
	public boolean isOutputWatch() {
		return isOutputWatch;
	}
	public void setOutputWatch(boolean isOutputWatch) {
		this.isOutputWatch = isOutputWatch;
		this.setOutputDTO(super.getOutputDTO());
	}
	public PublishSubject<Object> getWatchSubject() {
		return watchSubject;
	}
	public void setWatchSubject(PublishSubject<Object> watchSubject) {
		this.watchSubject = watchSubject;
	}
	@Override
	public void setInputDTO(InputDTO inputDTO) {
		// TODO Auto-generated method stub
		super.setInputDTO(inputDTO);
		watchSubject.onNext(inputDTO);
	}
	@Override
	public void setOutputDTO(OutputDTO outputDTO) {
		// TODO Auto-generated method stub
		super.setOutputDTO(outputDTO);
		watchSubject.onNext(outputDTO);
	}
}
