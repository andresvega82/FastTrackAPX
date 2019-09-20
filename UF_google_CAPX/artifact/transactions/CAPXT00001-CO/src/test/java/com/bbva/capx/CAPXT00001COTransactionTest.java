package com.bbva.capx;


import java.util.ArrayList;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.core.MultivaluedHashMap;

import com.bbva.capx.dto.googlemaps.DataIn;
import com.bbva.capx.lib.r001.CAPXR001;
import com.bbva.elara.configuration.manager.ConfigurationManager;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ParameterTable;
import com.bbva.elara.domain.transaction.RequestHeaderParamsName;
import com.bbva.elara.domain.transaction.Severity;
import com.bbva.elara.domain.transaction.TransactionParameter;
import com.bbva.elara.domain.transaction.request.HttpMethodCode;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.domain.transaction.response.HttpResponseCode;
import com.bbva.elara.support.provisioning.store.TransactionStoreDelegate;
import com.bbva.elara.support.visibility.VisibilityStore;
import com.bbva.elara.test.osgi.DummyBundleContext;
import com.bbva.elara.test.restful.MessageContextTest;


/**
 * Test for transaction CAPXT00001COTransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/CAPXT00001COTest.xml" })
public class CAPXT00001COTransactionTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CAPXT00001COTransactionTest.class);
	
	@Autowired
	private CAPXT00001COTransaction transaction;
	
	@Mock
	private DummyBundleContext bundleContext;
	private TransactionRequest transactionRequest;


	@Spy
	private Context context;
	private final HttpResponseCode[] finalResponseCode = { null };
	private final Severity[] finalSeverity = { null };

	@Mock
	private CAPXR001 capxR001;
	

	private void addMockService(Class toMock) {
		ServiceReference serviceReference = Mockito.mock(ServiceReference.class);
		Mockito.when(bundleContext.getServiceReference(toMock)).thenReturn(serviceReference);
		Mockito.when(bundleContext.getService(serviceReference)).thenReturn(Mockito.mock(toMock));
	}
	
	

	@Before
	public void initializeClass() throws Exception {

		MockitoAnnotations.initMocks(this);
		Bundle bundle = Mockito.mock(Bundle.class);
		Mockito.when(bundle.getSymbolicName()).thenReturn("CAPXT000-01-CO");
		Mockito.when(bundleContext.getBundle()).thenReturn(bundle);
		addMockService(TransactionStoreDelegate.class);
		addMockService(ConfigurationManager.class);
		addMockService(VisibilityStore.class);

		this.transaction = new CAPXT00001COTransaction() {

			@Override
			protected <T> T getServiceLibrary(Class<T> serviceInterface) {
				return (T) capxR001;
			}

			@Override
			protected void setHttpResponseCode(HttpResponseCode httpStatusCode, Severity severity) {				
				finalResponseCode[0] = httpStatusCode;
				finalSeverity[0] = severity;
			}
		};

		this.transaction.start(bundleContext);

		// Initializing transaction to test
		this.transaction.setContext(new Context());
		this.transaction.getContext().setLanguageCode("ES");

		transactionRequest = Mockito.mock(TransactionRequest.class);
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<TransactionParameter>());
		transactionRequest.setBody(commonRequestBody);
		Mockito.when(transactionRequest.getRestfulMethod()).thenReturn(null);
		this.transaction.getContext().setTransactionRequest(transactionRequest);

	}
	
	@Test
	public void executeTest() {
		
		Assert.assertNotNull(this.transaction);
		DataIn dataIn = new DataIn();
		dataIn.setDestination("Bogota");
		dataIn.setOrigin("Neiva");
		
		final TransactionParameter tParameter = new TransactionParameter("travelInfo", dataIn);
		this.transaction.getContext().getParameterList().put("travelInfo", tParameter);
		this.transaction.execute();
		
	}

}
