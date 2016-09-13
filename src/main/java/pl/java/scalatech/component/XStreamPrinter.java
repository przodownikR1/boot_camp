package pl.java.scalatech.component;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
@Component
@Slf4j
public class XStreamPrinter implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
       Person person = Person.builder().age(23).name("przodownik").salary(BigDecimal.TEN).build();
       log.info("person : {}",person);
        
    }

}
