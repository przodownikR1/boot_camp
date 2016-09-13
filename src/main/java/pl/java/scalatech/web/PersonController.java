package pl.java.scalatech.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

//@Controller  @ResponseBody
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) ) //final
public class PersonController {
    
    private final PersonResporitory personResporitory;
 
    private final MessageSource messageSource;
    
    @GetMapping(value="/persons")
    @ResponseBody
    List<Person> getPerson(){     
        return personResporitory.findAll();
    }
    @RequestMapping("/persons/{id}")
    Person findById(@PathVariable Long id){
        return personResporitory.findOne(id);
    }
  
    
    @RequestMapping("hello")
    String sayHello(Locale locale){
        return messageSource.getMessage("hello", null, locale );
    }
    
    
  
    
}
