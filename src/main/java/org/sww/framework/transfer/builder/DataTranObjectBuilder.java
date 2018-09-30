package org.sww.framework.transfer.builder;

public interface DataTranObjectBuilder {
	<T> T build();
	Class<?> getInputOfType();
	void setInputOfType(Class<?> inputOfType);
	Class<?> getOutputOfType();
	void setOutputOfType(Class<?> outputOfType);
}
