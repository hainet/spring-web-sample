package com.hainet.spring.web.sample.web.listener;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;

@Component
public class AppRequestContextListener extends RequestContextListener {

    @Override
    public void requestInitialized(final ServletRequestEvent requestEvent) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#requestInitialized");
        super.requestInitialized(requestEvent);
        System.out.println("LocaleContextHolder#getLocale: "
                + LocaleContextHolder.getLocale());
        System.out.println("RequestContextHolder#getRequestAttributes: "
                + RequestContextHolder.getRequestAttributes());
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent requestEvent) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#requestDestroyed");
        super.requestInitialized(requestEvent);
        System.out.println("LocaleContextHolder#getLocale: "
                + LocaleContextHolder.getLocale());
        System.out.println("RequestContextHolder#getRequestAttributes: "
                + RequestContextHolder.getRequestAttributes());
    }
}
