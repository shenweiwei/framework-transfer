package org.sww.framework.transfer.dto;

import io.reactivex.Observable;

public abstract class AbstractDTO implements DataTransferObject {
	private InputDTO inputDTO;
	private OutputDTO outputDTO;
	private Observable<?> inputObservable;
	private Observable<?> outputObservable;

	private <T> Observable<T> create(T t) {
		return Observable.create(observer -> {
			observer.onNext(t);
		});
	}
	public InputDTO getInputDTO() {
		return inputDTO;
	}
	public void setInputDTO(InputDTO inputDTO) {
		setInputObservable(this.create(inputDTO));
		this.getInputObservable().subscribe(dto -> {
			this.inputDTO = (InputDTO) dto;
		});
	}
	public OutputDTO getOutputDTO() {
		return outputDTO;
	}
	public void setOutputDTO(OutputDTO outputDTO) {
		setOutputObservable(this.create(outputDTO));
		this.getOutputObservable().subscribe(dto -> {
			this.outputDTO = (OutputDTO) dto;
		});
	}
	public Observable<?> getInputObservable() {
		return inputObservable;
	}
	public void setInputObservable(Observable<?> inputObservable) {
		this.inputObservable = inputObservable;
	}
	public Observable<?> getOutputObservable() {
		return outputObservable;
	}
	public void setOutputObservable(Observable<?> outputObservable) {
		this.outputObservable = outputObservable;
	}
}
