package org.sww.framework.transfer.builder;

public abstract class AbstractDataTranObjectBuilder implements DataTranObjectBuilder {
	protected Class<?> inputOfType;
	protected Class<?> outputOfType;

	@Override
	public Class<?> getInputOfType() {
		return inputOfType;
	}
	@Override
	public void setInputOfType(Class<?> inputOfType) {
		this.inputOfType = inputOfType;
	}
	@Override
	public Class<?> getOutputOfType() {
		return outputOfType;
	}
	@Override
	public void setOutputOfType(Class<?> outputOfType) {
		this.outputOfType = outputOfType;
	}
}
