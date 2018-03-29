package com.hainet.spring.web.sample.web;

import lombok.Data;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Map;

@RestController
public class RequestController {

    // curl -XGET http://localhost:8080/request-param?value=foo
    @GetMapping("/request-param")
    public String requestParamTest(@RequestParam final String value) {
        return "@RequestParam: " + value;
    }

    @InitBinder("requestParamForm")
    public void initBinder(final WebDataBinder binder, final HttpServletRequest request) {
        final MutablePropertyValues pvs = new MutablePropertyValues();
        for (final Field field : RequestParamForm.class.getDeclaredFields()) {
            pvs.add(field.getName(), request.getParameter(toKebabCase(field.getName())));
        }

        binder.bind(pvs);
    }

    private String toKebabCase(final String value) {
        final StringBuilder builder = new StringBuilder();
        for (final char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                builder.append("-").append(Character.toLowerCase(c));
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    // curl localhost:8080/request-param/init-binder?request-param-id=1&request-param-name=hainet
    @GetMapping("/request-param/init-binder")
    public String requestParamInitBinder(final RequestParamForm form) {
        return form.toString();
    }

    @Data
    private static class RequestParamForm {
        private int requestParamId;
        private String requestParamName;
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
        return "@RequestHeader\n" +
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
    private static class RequestBodyForm {
        private String value;
    }
}
