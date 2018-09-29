package org.sww.framework.transfer.builder;

import org.junit.Test;
import org.sww.framework.transfer.http.builder.HttpDataTranObjectBuilder;
import org.sww.framework.transfer.http.dto.HttpDataTransferObject;
import org.sww.framework.transfer.http.dto.HttpRequestDTO;
import org.sww.framework.transfer.http.dto.HttpResposneDTO;

public class HttpBuilderTest {
	
	@Test
	public void createHttpBuilder() {
		DataTranObjectBuilder httpDataTranObjectBuilder = HttpDataTranObjectBuilder.builder(HttpRequestDTO.class,
				HttpResposneDTO.class);
		HttpDataTransferObject httpDataTransferObject = httpDataTranObjectBuilder.build();
		System.out.println(httpDataTransferObject);
	}
}
