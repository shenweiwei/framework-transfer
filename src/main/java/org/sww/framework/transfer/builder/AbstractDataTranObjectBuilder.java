package org.sww.framework.transfer.builder;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public abstract class AbstractDataTranObjectBuilder implements DataTranObjectBuilder {
//	protected static Logger logger = LoggerFactory.getLogger(DataTranObjectBuilder.class);
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
