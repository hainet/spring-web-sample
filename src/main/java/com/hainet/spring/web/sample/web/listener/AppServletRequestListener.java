package com.hainet.spring.web.sample.web.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

@Component
public class AppServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(final ServletRequestEvent requestEvent) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#requestInitialized");
        System.out.println("ServletRequestEvent: " + requestEvent);
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent requestEvent) {
        System.out.println("-- " + this.getClass().getSimpleName() + "#requestDestroyed");
        System.out.println("ServletRequestEvent: " + requestEvent);
    }
}
