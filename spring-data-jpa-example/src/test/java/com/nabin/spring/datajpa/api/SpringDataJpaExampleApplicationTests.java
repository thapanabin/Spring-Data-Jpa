package com.nabin.spring.datajpa.api;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataJpaExampleApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringDataJpaExampleApplicationTests {
	
	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testGetUsers() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		ResponseEntity<String> response = restTemplate.exchange(createUrlWithPort("/getUsers"), HttpMethod.GET,entity,String.class);
		String expected = "[{\n" + 
				"        \"id\": 111,\n" + 
				"        \"name\": \"x\",\n" + 
				"        \"profession\": \"IT\",\n" + 
				"        \"age\": 20\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": 222,\n" + 
				"        \"name\": \"y\",\n" + 
				"        \"profession\": \"CIVIL\",\n" + 
				"        \"age\": 21\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": 333,\n" + 
				"        \"name\": \"z\",\n" + 
				"        \"profession\": \"GOVT\",\n" + 
				"        \"age\": 22\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": 444,\n" + 
				"        \"name\": \"w\",\n" + 
				"        \"profession\": \"IT\",\n" + 
				"        \"age\": 29\n" + 
				"    },\n" + 
				"    {\n" + 
				"        \"id\": 555,\n" + 
				"        \"name\": \"e\",\n" + 
				"        \"profession\": \"IT\",\n" + 
				"        \"age\": 20\n" + 
				"    }]";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	public String createUrlWithPort(String url) {
		return "http://localhost:"+port+url;
	}
	

	
}
