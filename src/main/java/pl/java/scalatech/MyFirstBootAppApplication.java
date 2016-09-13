package pl.java.scalatech;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.thoughtworks.xstream.XStream;

import de.codecentric.boot.admin.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(basePackages="pl.java.scalatech") //konieczne do funkcjonowania Spring Data
@EnableAdminServer
public class MyFirstBootAppApplication implements CommandLineRunner{

   
  
    @Bean
    CommandLineRunner xprinter(XStream xstream){
        return args -> {
            Person person = Person.builder().age(23).name("przodownik").salary(BigDecimal.TEN).build();  
            log.info("person : {}",xstream.toXML(person));
        };
    }
    
    
    @Autowired
    private PersonResporitory personResporitory;
    
	public static void main(String[] args) {
		SpringApplication.run(MyFirstBootAppApplication.class, args);
	}
	
   
	
    @Override
    public void run(String... args) throws Exception {
        personResporitory.save(Person.builder().age(10).name("przodownik").build());
        personResporitory.save(Person.builder().age(10).name("przodownik").build());
      
        
    }
}
