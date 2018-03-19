package com.hainet.spring.web.sample.config;

import com.hainet.spring.web.sample.web.interceptor.AppHandlerInterceptor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private final AppHandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry
                .addInterceptor(handlerInterceptor)
                .addPathPatterns("/handler-interceptor/**")
                .excludePathPatterns("/handler-interceptor/exclude");
    }

    // リクエストとレスポンスの詳細をリクエスト毎にログ出力する。
    @Bean
    @Profile("dev")
    public RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
