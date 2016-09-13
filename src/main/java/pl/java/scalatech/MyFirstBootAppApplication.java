package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

@SpringBootApplication
@Slf4j
public class MyFirstBootAppApplication implements CommandLineRunner{

   
  
   
    
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
