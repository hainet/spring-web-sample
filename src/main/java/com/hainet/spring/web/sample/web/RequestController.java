package com.hainet.spring.web.sample.web;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {

    // curl -XGET http://localhost:8080/request-param?value=foo
    @GetMapping("/request-param")
    public String requestParamTest(@RequestParam final String value) {
        return "@RequestParam: " + value;
    }

    // curl -XGET http://localhost:8080/path-valiable/bar
    @GetMapping("/path-variable/{value}")
    public String pathVariableTest(@PathVariable final String value) {
        return "@PathVariable: " + value;
    }

    // curl -XGET localhost:8080/request-body -H 'Content-type: application/json' -d '{"value": "baz"}'
    @GetMapping("/request-body")
    public String requestBodyTest(@RequestBody final RequestForm form) {
        return "@RequestBody: " + form;
    }

    @Data
    public static class RequestForm {

        private String value;
    }
}
