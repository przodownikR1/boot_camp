package pl.java.scalatech.web;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import pl.java.scalatech.component.DbProp;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.exception.My401Exception;
import pl.java.scalatech.repository.PersonResporitory;

//@Controller  @ResponseBody
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) ) //final
public class PersonController {
    
    private final PersonResporitory personResporitory;
 
    private final DbProp prop;
    
    private final MessageSource messageSource;
    
    @GetMapping(value="/persons")
    @ResponseBody
    List<Person> getPerson(){
        StopWatch sw = new StopWatch();
        sw.start();
        dupa();
        sw.stop();    
        
        return personResporitory.findAll();
    }
    @RequestMapping("/persons/{id}")
    Person findById(@PathVariable Long id){
        return personResporitory.findOne(id);
    }
    @RequestMapping("/prop") 
    DbProp getProperty(){
        return prop;
       
    }
    
    @RequestMapping("hello")
    String sayHello(Locale locale){
        return messageSource.getMessage("hello", null, locale );
    }
    
    @RequestMapping("/401")
    String generate401(){
        throw new My401Exception();
    }
    
    @SneakyThrows
    private void dupa() {
        Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
        System.out.println("slawek ....");
    }
    
}
