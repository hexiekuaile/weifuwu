package com.yw.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        return restTemplate.getForEntity("http://SERVICE-ORDER/order", String.class).getBody();
    }

}
