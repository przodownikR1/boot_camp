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

import com.google.common.collect.Lists;

import static com.google.common.collect.Lists.newArrayList;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.domain.Role;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.PersonResporitory;
import pl.java.scalatech.repository.RoleRepository;
import pl.java.scalatech.repository.UserRepository;

@SpringBootApplication
@Slf4j
public class MyFirstBootAppApplication {

    @Autowired
    private PersonResporitory personResporitory;
    
    
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    
    
    @Bean
    CommandLineRunner runOne(){
        return args -> {
            personResporitory.save(Person.builder().age(10).name("przodownik").build());
            personResporitory.save(Person.builder().age(10).name("przodownik").build());
            log.info(" en :  {}",messageSource.getMessage("hello",null, Locale.ENGLISH));
            log.info(" pl :  {}",messageSource.getMessage("hello",null, Locale.getDefault()));
            log.info("full context start ...");
            Role user = new Role("USER", "only for ordinary user");
            Role admin =new Role("ADMIN", "only for special right user");
            log.info("+++++++++++++   {}", user.getId());
            user = roleRepository.save(user);
            admin = roleRepository.save(admin); 
            User one = userRepository.save(User.builder().firstName("slawek").login("przodownik").password("vava").enabled(true).build());
            User two = userRepository.save(User.builder().firstName("vava").login("vava").password("vava").enabled(true).build());

            one.setRoles(newArrayList(user, admin));
            two.setRoles(newArrayList(user));
            User oneLoaded = userRepository.save(one);
            userRepository.save(two);
            
        };
    }
    
    @Bean
    InitializingBean runTwo(){
       return  () -> log.info("set propreties ... ");
    }
   
    
    
	public static void main(String[] args) {
		SpringApplication.run(MyFirstBootAppApplication.class, args);
	}
	
   
	
    
}
