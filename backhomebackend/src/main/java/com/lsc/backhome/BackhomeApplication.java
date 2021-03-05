package com.lsc.backhome;

import com.lsc.backhome.jwt.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@MapperScan("com.lsc.backhome.mapper")
@SpringBootApplication
public class BackhomeApplication extends SpringBootServletInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(BackhomeApplication.class);
//    }
//    @Bean
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
//        registrationBean.setFilter(filter);
//        return registrationBean;
//    }

    public static void main(String[] args) {
        SpringApplication.run(BackhomeApplication.class, args);
    }

}
