package org.sww.framework.transfer.dto;

/**
 * @author Administrator
 */
public abstract class AbstractDTO<I, O> implements DataTransferObject<I, O> {
	private InputDTO<I> inputDTO;
	private OutputDTO<O> outputDTO;

	public InputDTO<I> getInputDTO() {
		return inputDTO;
	}
	public void setInputDTO(InputDTO<I> inputDTO) {
		this.inputDTO = inputDTO;
	}
	public OutputDTO<O> getOutputDTO() {
		return outputDTO;
	}
	public void setOutputDTO(OutputDTO<O> outputDTO) {
		this.outputDTO = outputDTO;
	}
}
