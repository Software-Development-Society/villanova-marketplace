package com.example.marketplaceapi.controllers;

import groovy.json.JsonSlurper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActiveListingController {
    private static final JsonSlurper slurper =  new JsonSlurper();
}
