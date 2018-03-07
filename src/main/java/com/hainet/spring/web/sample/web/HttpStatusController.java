package com.hainet.spring.web.sample.web;

import com.hainet.spring.web.sample.web.exception.HttpStatus404Exception;
import com.hainet.spring.web.sample.web.exception.HttpStatus500Exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HttpStatusController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void handleHttpStatusByResponseStatus() {
    }

    @GetMapping("/controller-advice/{httpStatus}")
    public void handleHttpStatusByControllerAdvice(@PathVariable final String httpStatus) {
        switch (httpStatus) {
            case "404":
                throw new HttpStatus404Exception();
            case "500":
                throw new HttpStatus500Exception();
            default:
        }
    }

    @GetMapping("/http-servlet-response/{httpStatus}")
    public void handleHttpStatusByHttpServletResponse(
            final HttpServletResponse response,
            @PathVariable final int httpStatus) {
        response.setStatus(httpStatus);
    }

    @GetMapping("/response-entity/{httpStatus}")
    public ResponseEntity<String> responseEntity(@PathVariable final int httpStatus) {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.valueOf(httpStatus));
    }
}
