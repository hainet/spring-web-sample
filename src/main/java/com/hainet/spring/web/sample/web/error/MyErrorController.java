package com.hainet.spring.web.sample.web.error;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(final HttpServletRequest request) {
        // Logging, handling, etc...
        System.out.println("-- " + this.getClass().getSimpleName() + "#handleError");

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
