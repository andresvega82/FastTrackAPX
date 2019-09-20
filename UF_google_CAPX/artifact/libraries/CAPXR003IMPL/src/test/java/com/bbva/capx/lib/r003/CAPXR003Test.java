package com.bbva.capx.lib.r003;

import static org.mockito.Matchers.anyString;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.bbva.capx.lib.r003.impl.CAPXR003Impl;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;

import junit.framework.Assert;


public class CAPXR003Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CAPXR003.class);
	
	@InjectMocks
	private CAPXR003Impl capxR003;

	@Mock
	private RestTemplate restTemplate;
	

	
	

	@Spy
	private Context context;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ThreadContext.set(context);
		getObjectIntrospection();
	}

	private Object getObjectIntrospection() throws Exception {
		Object result = this.capxR003;
		if (this.capxR003 instanceof Advised) {
			Advised advised = (Advised) this.capxR003;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	
	/**
	 * Test best route with origin Bogota to destination Mosquera
	 */
	@Test
	public void executeTest() {
}

}
