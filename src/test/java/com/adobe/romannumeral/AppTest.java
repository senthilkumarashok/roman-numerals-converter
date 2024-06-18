package com.adobe.romannumeral;

import static org.assertj.core.api.Assertions.assertThat;

import com.adobe.romannumeral.view.RomanNumeralResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest 
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testQuery() {
        String QUERY_URL = "http://localhost:" + port + "/romannumeral/v1?query=11";
        ResponseEntity<String> response = this.restTemplate.getForEntity(QUERY_URL, String.class);
        assertThat(response.getBody()).contains("{\"input\":\"11\",\"output\":\"XI\"}");
    }
}
