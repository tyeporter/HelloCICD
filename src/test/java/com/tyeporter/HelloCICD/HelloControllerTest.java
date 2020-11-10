package com.tyeporter.HelloCICD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = HelloCicdApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> getEntity;

    // =========================================================
    // Setup
    // =========================================================
    @BeforeEach
    public void setup() {
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
        getEntity = new HttpEntity<>(null, headers);
    }

    @Test
    public void testAddIntegers() {
        ResponseEntity<String> response = restTemplate.exchange(
            createUrlWithPort("/Tye"), 
            HttpMethod.GET, 
            getEntity, 
            String.class
        );

        String expected = "Hello, Tye!";
        assertEquals(expected, response.getBody());
    }

    @Test
    public void failingTest() {
    	fail("Creating a failing test on purpose");
    }
    
    // =========================================================
    // HELPER METHODS
    // =========================================================
    private String createUrlWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}