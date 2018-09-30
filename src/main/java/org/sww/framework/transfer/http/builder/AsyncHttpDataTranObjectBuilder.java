package org.sww.framework.transfer.http.builder;

import org.apache.commons.lang3.ObjectUtils;

public class AsyncHttpDataTranObjectBuilder extends HttpDataTranObjectBuilder {
	
	public static AsyncHttpDataTranObjectBuilder builder(Class<?> inputDTO, Class<?> outputDTO) {
		AsyncHttpDataTranObjectBuilder asyncHttpDataTranObjectBuilder = new AsyncHttpDataTranObjectBuilder();
		asyncHttpDataTranObjectBuilder.setInputOfType(inputDTO);
		if (ObjectUtils.allNotNull(inputDTO))
			asyncHttpDataTranObjectBuilder.setOutputOfType(outputDTO);
		return asyncHttpDataTranObjectBuilder;
	}
}
