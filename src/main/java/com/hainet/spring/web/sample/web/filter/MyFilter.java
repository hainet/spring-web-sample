package com.hainet.spring.web.sample.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = {"/**"})
public class MyFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#init");
        System.out.println("FilterConfig: " + filterConfig);
    }

    @Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain) throws IOException, ServletException {
        System.out.println("-- " + this.getClass().getSimpleName() + "#doFilter");
        System.out.println("ServletRequest: " + request);
        System.out.println("ServletResponse: " + response);
        System.out.println("FilterChain: " + chain);
        System.out.println("Before chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
        chain.doFilter(request, response);
        System.out.println("After chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
    }

    @Override
    public void destroy() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#destroy");
    }
}
