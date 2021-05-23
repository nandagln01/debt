package com.interview.project.debt.functional;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.project.debt.domain.DebtUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class EndPointTest {

    @Autowired
    RestTemplate restTemplate;

    @Value("${debt.url}")
    private String DEBT_URL;

  //  @Autowired
   // private DebtUrl debtData;



    @Test
    public void shouldReturnDebts() throws Exception{
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(DEBT_URL)
                .build();

        String uri = uriComponents.toUriString();

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());

        System.out.println(response.toString());
    }

   /* @Test
    public void shouldReturnPayments() throws Exception{

    }

    @Test
    public void shouldReturnPaymentPlans() throws Exception{

    }*/
}
