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
        System.out.println(super.getAlreadyFilteredAttributeName());
        System.out.println("Before chain.doFilter in " + this.getClass().getSimpleName() + "#doFilterInternal");
        filterChain.doFilter(request, response);
        System.out.println("After chain.doFilter in " + this.getClass().getSimpleName() + "#doFilterInternal");
    }

    @Override
    public boolean shouldNotFilter(final HttpServletRequest request) {
        return false;
    }
}
