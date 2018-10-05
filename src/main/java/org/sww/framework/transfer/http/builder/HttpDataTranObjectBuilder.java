package org.sww.framework.transfer.http.builder ;

import org.apache.commons.lang3.ObjectUtils ;
import org.junit.Assert ;
import org.sww.framework.transfer.builder.AbstractDataTranObjectBuilder ;
import org.sww.framework.transfer.builder.DataTranObjectBuilder ;
import org.sww.framework.transfer.dto.DataTransferObject ;
import org.sww.framework.transfer.dto.InputDTO ;
import org.sww.framework.transfer.dto.OutputDTO ;
import org.sww.framework.transfer.http.dto.HttpDataTransferObject ;
import org.sww.framework.transfer.http.dto.HttpResposneDTO ;

/**
 * @author Administrator
 */
public class HttpDataTranObjectBuilder extends AbstractDataTranObjectBuilder {
	
	public static DataTranObjectBuilder builder(Class<?> inputDTO, Class<?> outputDTO) {
		DataTranObjectBuilder dataTranObjectBuilder = new HttpDataTranObjectBuilder() ;
		dataTranObjectBuilder.setInputOfType(inputDTO) ;
		if (ObjectUtils.allNotNull(inputDTO)) dataTranObjectBuilder.setOutputOfType(outputDTO) ;
		return dataTranObjectBuilder ;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DataTransferObject build() {
		try {
			Assert.assertNotNull("The class must not be null", inputOfType) ;
			if (ObjectUtils.allNotNull(outputOfType)) {
				return new HttpDataTransferObject((InputDTO) inputOfType.newInstance(), (OutputDTO) outputOfType.newInstance()) ;
			}
			return new HttpDataTransferObject((InputDTO) inputOfType.newInstance(), (OutputDTO) new HttpResposneDTO()) ;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e) ;
		}
	}
}
