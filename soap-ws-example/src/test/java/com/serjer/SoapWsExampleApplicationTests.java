package com.serjer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.serjer.soap_ws_example.GetCountryRequest;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SoapWsExampleApplicationTests {


	    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

	    @LocalServerPort
	    private int port = 0;

	    @Before
	    public void init() throws Exception {
	        marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCountryRequest.class));
	        marshaller.afterPropertiesSet();
	    }

	    @Test
	    public void testSendAndReceive() {
	        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
	        GetCountryRequest request = new GetCountryRequest();
	        request.setName("Spain");

	        assertThat(ws.marshalSendAndReceive("http://localhost:"
	                + port + "/ws", request)).isNotNull();
	    }
	}
