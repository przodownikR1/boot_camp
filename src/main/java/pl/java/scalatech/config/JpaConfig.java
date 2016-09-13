package pl.java.scalatech.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
@Configuration
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@Slf4j
public class JpaConfig {
    @PostConstruct
    public void log(){
        log.info("++++++++++++++++++++++++++++++++++++ jpaConfig");
    }
    
}
