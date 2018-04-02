package com.hainet.spring.web.sample.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
public class MyGenericFilterBean extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        System.out.println("-- " + this.getClass().getSimpleName() + "#doFilter");
        System.out.println(super.getEnvironment());
        System.out.println(super.getFilterConfig());
        System.out.println("Before chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
        chain.doFilter(request, response);
        System.out.println("After chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
    }
}
