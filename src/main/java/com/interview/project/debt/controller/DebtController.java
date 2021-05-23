package com.interview.project.debt.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.project.debt.domain.Debt;
import com.interview.project.debt.domain.DebtUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@RestController
public class DebtController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DebtUrl debtData;


    @PostMapping("/debts/")
    public String getDebts(Model model )
            throws JsonParseException, JsonMappingException, IOException{

        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(debtData.getUrl())
                .build();

        String uri = uriComponents.toUriString();

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Debt debt = mapper.readValue(response.getBody(), Debt.class);
        model.addAttribute("debtData", debt);

        return "debtDetails";
    }
}
