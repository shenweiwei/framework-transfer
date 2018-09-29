package org.sww.framework.transfer.builder;

public interface DataTranObjectBuilder {
	public <T> T build();
	public Class<?> getInputOfType();
	public void setInputOfType(Class<?> inputOfType);
	public Class<?> getOutputOfType();
	public void setOutputOfType(Class<?> outputOfType);
}
