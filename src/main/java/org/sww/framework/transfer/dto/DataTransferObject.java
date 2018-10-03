package org.sww.framework.transfer.dto;

public interface DataTransferObject<I, O> {
	void setInputDTO(InputDTO<I> inputDTO);
	InputDTO<I> getInputDTO();
	void setOutputDTO(OutputDTO<O> outputDTO);
	OutputDTO<O> getOutputDTO();
}
