package com.hainet.spring.web.sample.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

@Component
public class AppServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(final ServletRequestEvent sre) {
        System.out.println(this.getClass().getSimpleName() + "#requestInitialized");
        System.out.println(sre);
    }

    @Override
    public void requestDestroyed(final ServletRequestEvent sre) {
        System.out.println(this.getClass().getSimpleName() + "#requestDestroyed");
        System.out.println(sre);
    }
}
