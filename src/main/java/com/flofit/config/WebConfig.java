package com.flofit.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
 @Value("${flofit.cors.allowed-origin-patterns:http://localhost:5173,http://127.0.0.1:5173}") private String origins;
 @Override public void addCorsMappings(CorsRegistry r) { r.addMapping("/api/**").allowedOriginPatterns(origins.split(",")).allowedMethods("GET","POST","PUT","DELETE","OPTIONS").allowedHeaders("*"); }
}
