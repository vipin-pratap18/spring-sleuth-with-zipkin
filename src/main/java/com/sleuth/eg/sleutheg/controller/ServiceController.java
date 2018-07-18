package com.sleuth.eg.sleutheg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@RequestMapping("/action")
public class ServiceController {

    private static final Logger LOG = Logger.getLogger(ServiceController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String sayHello(){
        LOG.info("Hello, Calling");
        return "Hello, Calling";
    }

    @GetMapping("/hello-said")
    public String helloSaid(){
        LOG.info("Hello, Called");
        return restTemplate.getForObject("http://localhost:8081/action/hello", String.class);
    }
}
