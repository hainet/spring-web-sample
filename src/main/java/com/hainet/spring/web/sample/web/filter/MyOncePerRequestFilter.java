package com.hainet.spring.web.sample.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyOncePerRequestFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-- " + this.getClass().getSimpleName() + "#doFilterInternal");
        System.out.println("Before chain.doFilter in " + this.getClass().getSimpleName() + "#doFilterInternal");
        filterChain.doFilter(request, response);
        System.out.println("After chain.doFilter in " + this.getClass().getSimpleName() + "#doFilterInternal");
    }

    @Override
    public boolean isAsyncDispatch(final HttpServletRequest request) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#isAsyncDispath");
        System.out.println("HttpServletRequest: " + request);
        return super.isAsyncDispatch(request);
    }

    @Override
    public boolean isAsyncStarted(final HttpServletRequest request) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#isAsyncStarted");
        System.out.println("HttpServletRequest: " + request);
        return super.isAsyncStarted(request);
    }

    @Override
    public String getAlreadyFilteredAttributeName() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#isAsyncStarted");
        return super.getAlreadyFilteredAttributeName();
    }

    @Override
    public boolean shouldNotFilter(final HttpServletRequest request) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#shouldNotFilter");
        System.out.println("HttpServletRequest: " + request);
        return false;
    }

    @Override
    public boolean shouldNotFilterAsyncDispatch() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#shouldNotFilterAsyncDispatch");
        return super.shouldNotFilterAsyncDispatch();
    }

    @Override
    public boolean shouldNotFilterErrorDispatch() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#shouldNotFilterErrorDispatch");
        return super.shouldNotFilterErrorDispatch();
    }
}
