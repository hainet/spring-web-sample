package com.hainet.spring.web.sample.web;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    // curl -XGET http://localhost:8080/request-header -H 'Header-value: baz'
    @GetMapping("/request-header")
    public String requestHeaderTest(
            @RequestHeader("Header-value") final String headerValue,
            @RequestHeader final Map<String, Object> map,
            @RequestHeader final HttpHeaders httpHeaders,
            @RequestHeader(value = "Not-required", required = false) final String notRequired,
            @RequestHeader(value = "", defaultValue = "This is default value.") final String defaultValue) {
        return
                "@RequestHeader\n" +
                "  Header-value: " + headerValue + "\n" +
                "  Map<String, Object>: " + map + "\n" +
                "  HttpHeaders: " + httpHeaders + "\n" +
                "  required = false: " + notRequired + "\n" +
                "  defaultValue = \"This is default value.\": " + defaultValue + "\n";
    }

    // curl -XGET http://localhost:8080/request-body -H 'Content-type: application/json' -d '{"value": "baz"}'
    @GetMapping("/request-body")
    public String requestBodyTest(@RequestBody final RequestBodyForm form) {
        return "@RequestBody: " + form;
    }

    @Data
    public static class RequestBodyForm {
        private String value;
    }
}
