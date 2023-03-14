package com.example.consumingrest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {
    RestTemplate restTemplate = new RestTemplate();
    public CovidQuote[] getCovidQuote(){
        CovidQuote[] quote = restTemplate.getForObject(
					"https://analisi.transparenciacatalunya.cat/resource/623z-r97q.json", CovidQuote[].class);
        return quote;
    }
}
