package com.codeki.travelagency.dollar.utils;

import com.codeki.travelagency.dollar.model.Dollar;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DollarUtils {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    // ------------------  METHODS  ------------------
    public Dollar fetchDollar() {
        RestTemplate restTemplate = restTemplate();
        String dollarApiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(dollarApiUrl, Dollar.class);
    }
}
