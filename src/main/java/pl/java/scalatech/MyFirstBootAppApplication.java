package pl.java.scalatech;

import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

@SpringBootApplication
@Slf4j
public class MyFirstBootAppApplication {

    @Bean
    CommandLineRunner runOne(){
        return args -> {
            personResporitory.save(Person.builder().age(10).name("przodownik").build());
            personResporitory.save(Person.builder().age(10).name("przodownik").build());
            log.info(" en :  {}",messageSource.getMessage("hello",null, Locale.ENGLISH));
            log.info(" pl :  {}",messageSource.getMessage("hello",null, Locale.getDefault()));
            log.info("full context start ...");
            
        };
    }
    
    @Bean
    InitializingBean runTwo(){
       return  () -> log.info("set propreties ... ");
    }
   
    
    @Autowired
    private PersonResporitory personResporitory;
    
    @Autowired
    private MessageSource messageSource;
    
	public static void main(String[] args) {
		SpringApplication.run(MyFirstBootAppApplication.class, args);
	}
	
   
	
    
}
