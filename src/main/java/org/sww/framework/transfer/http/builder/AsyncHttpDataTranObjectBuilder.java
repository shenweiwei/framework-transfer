package org.sww.framework.transfer.http.builder ;

import org.apache.commons.lang3.ObjectUtils ;
import org.junit.Assert ;
import org.sww.framework.transfer.dto.InputDTO ;
import org.sww.framework.transfer.dto.OutputDTO ;
import org.sww.framework.transfer.http.dto.AsyncHttpDataTransferObject ;
import org.sww.framework.transfer.http.dto.HttpResposneDTO ;

public class AsyncHttpDataTranObjectBuilder extends HttpDataTranObjectBuilder {
	
	public static AsyncHttpDataTranObjectBuilder builder(Class<?> inputDTO, Class<?> outputDTO) {
		AsyncHttpDataTranObjectBuilder asyncHttpDataTranObjectBuilder = new AsyncHttpDataTranObjectBuilder() ;
		asyncHttpDataTranObjectBuilder.setInputOfType(inputDTO) ;
		if (ObjectUtils.allNotNull(inputDTO)) asyncHttpDataTranObjectBuilder.setOutputOfType(outputDTO) ;
		return asyncHttpDataTranObjectBuilder ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AsyncHttpDataTransferObject build() {
		try {
			Assert.assertNotNull("The class must not be null", inputOfType) ;
			if (ObjectUtils.allNotNull(outputOfType)) {
				return new AsyncHttpDataTransferObject((InputDTO) inputOfType.newInstance(), (OutputDTO) outputOfType.newInstance()) ;
			}
			return new AsyncHttpDataTransferObject((InputDTO) inputOfType.newInstance(), (OutputDTO) new HttpResposneDTO()) ;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e) ;
		}
	}
	
}
