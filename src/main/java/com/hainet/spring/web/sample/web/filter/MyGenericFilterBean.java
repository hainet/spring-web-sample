package com.hainet.spring.web.sample.web.filter;

import org.springframework.beans.BeanWrapper;
import org.springframework.core.env.Environment;
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
        System.out.println("super#getEnvironment: " + super.getEnvironment());
        System.out.println("super#getFilterConfig: " + super.getFilterConfig());
        System.out.println("Before chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
        chain.doFilter(request, response);
        System.out.println("After chain.doFilter in " + this.getClass().getSimpleName() + "#doFilter");
    }

    @Override
    public Environment createEnvironment() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#createEnvironment");
        return super.createEnvironment();
    }

    @Override
    public void initBeanWrapper(final BeanWrapper bw) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#initBeanWrapper");
        System.out.println("BeanWrapper: " + bw);
    }

    @Override
    public void initFilterBean() {
        System.out.println("-- " + this.getClass().getSimpleName() + "#initFilterBean");
    }
}
