package org.sww.framework.transfer.dto;

public interface DataTransferObject {
	void setInputDTO(InputDTO inputDTO);
	InputDTO getInputDTO();
	void setOutputDTO(OutputDTO outputDTO);
	OutputDTO getOutputDTO();
}
