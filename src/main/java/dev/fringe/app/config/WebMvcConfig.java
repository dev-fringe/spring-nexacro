package dev.fringe.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@EnableWebMvc
@ImportResource("classpath:context-common.xml")
public class WebMvcConfig{ 
//implements WebMvcConfigurer {
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("static/**").addResourceLocations("classpath:/static/");
//    }
}