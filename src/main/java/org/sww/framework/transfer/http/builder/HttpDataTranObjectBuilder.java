package org.sww.framework.transfer.http.builder;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.sww.framework.transfer.builder.AbstractDataTranObjectBuilder;
import org.sww.framework.transfer.builder.DataTranObjectBuilder;
import org.sww.framework.transfer.dto.DataTransferObject;
import org.sww.framework.transfer.http.dto.HttpDataTransferObject;

/**
 * @author Administrator
 */
public class HttpDataTranObjectBuilder extends AbstractDataTranObjectBuilder {
	public static DataTranObjectBuilder builder(Class<?> inputDTO, Class<?> outputDTO) {
		DataTranObjectBuilder dataTranObjectBuilder = new HttpDataTranObjectBuilder();
		dataTranObjectBuilder.setInputOfType(inputDTO);
		if (ObjectUtils.allNotNull(inputDTO))
			dataTranObjectBuilder.setOutputOfType(outputDTO);
		return dataTranObjectBuilder;
	}
	@Override
	@SuppressWarnings("unchecked")
	public DataTransferObject build() {
		try {
			Assert.assertNotNull("The class must not be null", inputOfType);
			if (ObjectUtils.allNotNull(outputOfType)) {
				return new HttpDataTransferObject(inputOfType.newInstance(), outputOfType.newInstance());
			}
			return (DataTransferObject) inputOfType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
