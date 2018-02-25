package com.hainet.spring.web.sample.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    // リクエストとレスポンスの詳細をリクエスト毎にログ出力する。
    @Bean
    @Profile("dev")
    public RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
