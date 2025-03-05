package com.example.PatientFlow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //This will start Spring Boot application and make it available for our test
class PatientFlowApplicationTests {
	@Autowired //asked spring to inject a test helper that'll allow us to make HTTP requests to the locally running application.
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnAPatientWhenDataIsSaved(){
		ResponseEntity<String> response = restTemplate.getForEntity("/patients/24",String.class);

		System.out.println("Response body: " + response.getBody());

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number id = documentContext.read("$.id");
		assertThat(id).isNotNull();
	}

}
