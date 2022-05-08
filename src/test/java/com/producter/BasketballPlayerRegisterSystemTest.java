package com.producter;

import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketballPlayerRegisterSystemTest {

	private final String REQUEST_PATH = "request/%s.graphql";
	private final String RESPONSE_PATH = "response/%s.json";

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;

	@Test
	void getAllPlayersTest() throws IOException {
		String testName = "get-all-players";
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(String.format(REQUEST_PATH, testName));
		System.out.println(graphQLResponse.getRawResponse());
		var expectedResponseBody = read(String.format(RESPONSE_PATH, testName));
		Assertions.assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody());
		
	}

	@Test
	void addPlayerTest() throws IOException {
		String testName = "add-player";
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(String.format(REQUEST_PATH, testName));
		System.out.println(graphQLResponse.getRawResponse());
		var expectedResponseBody = read(String.format(RESPONSE_PATH, testName));
		Assertions.assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody());
	}

	@Test
	void deletePlayerTest() throws IOException {
		String testName = "delete-player";
		GraphQLResponse graphQLResponse = graphQLTestTemplate.postForResource(String.format(REQUEST_PATH, testName));
		System.out.println(graphQLResponse.getRawResponse());
		var expectedResponseBody = read(String.format(RESPONSE_PATH, testName));
		Assertions.assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(expectedResponseBody, graphQLResponse.getRawResponse().getBody());
	}

	private String read(String location) throws IOException {
		return IOUtils.toString(new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
	}
}