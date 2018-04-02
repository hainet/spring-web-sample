package com.hainet.spring.web.sample.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
// HandlerInterceptorを実装すると要件によっては空実装が発生するため、
// HandlerInterceptorの抽象クラスであるHandlerInterceptorAdapterを拡張する。
public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler) {
        System.out.println("preHandle\n" +
                "  HttpServletRequest: " + request + "\n" +
                "  HttpServletResponse: " + response + "\n" +
                "  Object: " + handler);

        return true;
    }

    @Override
    // 例外が発生した場合には処理が行われない。
    public void postHandle(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler,
            final ModelAndView modelAndView) {
        System.out.println("postHandle\n" +
                "  HttpServletRequest: " + request + "\n" +
                "  HttpServletResponse: " + response + "\n" +
                "  Object: " + handler + "\n" +
                "  ModelAndView" + modelAndView);
    }

    @Override
    // 例外が発生した場合でも処理が行われる。
    public void afterCompletion(
            final HttpServletRequest request,
            final HttpServletResponse response,
            final Object handler,
            final Exception e) {
        System.out.println("afterCompletion\n" +
                "  HttpServletRequest: " + request + "\n" +
                "  HttpServletResponse: " + response + "\n" +
                "  Object: " + handler + "\n" +
                "  Exception: " + e);
    }
}
