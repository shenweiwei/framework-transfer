package org.sww.framework.transfer.dto;

public abstract class AbstractDTO implements DataTransferObject{
	protected InputDTO inputDTO;
	protected OutputDTO outputDTO;
	
	public InputDTO getInputDTO() {
		return inputDTO;
	}
	public void setInputDTO(InputDTO inputDTO) {
		this.inputDTO = inputDTO;
	}
	public OutputDTO getOutputDTO() {
		return outputDTO;
	}
	public void setOutputDTO(OutputDTO outputDTO) {
		this.outputDTO = outputDTO;
	}
}
