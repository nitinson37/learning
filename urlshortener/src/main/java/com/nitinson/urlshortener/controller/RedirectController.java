package com.nitinson.urlshortener.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class RedirectController {

    @GetMapping("/{id}")
    public ResponseEntity<?> handleRedirect(@PathVariable String id) throws URISyntaxException {
        URI uri = new URI("http://google.com");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createRedirect(@PathVariable String id){
        return null;
    }
}
