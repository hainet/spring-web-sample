package com.hainet.spring.web.sample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandlerInterceptorController {

    @GetMapping("/handler-interceptor")
    public void handlerInterceptor() {
        System.out.println(this.getClass().getSimpleName() + "#handlerInterceptor");
    }

    @GetMapping("/handler-interceptor/exception")
    public void handlerInterceptorException() {
        throw new RuntimeException(this.getClass().getSimpleName() + "#handlerInterceptorException");
    }

    @GetMapping("/handler-interceptor/exclude")
    public void handlerInterceptorExclude() {
        System.out.println(this.getClass().getSimpleName() + "#handlerInterceptorExclude");
    }
}
