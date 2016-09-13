package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AdminBootConfig extends WebMvcConfigurerAdapter{
 
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    registry.addResourceHandler("index.html").addResourceLocations("classpath:/META-INF/spring-boot-admin-server-ui/");
}
}