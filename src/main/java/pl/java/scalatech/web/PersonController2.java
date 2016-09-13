package pl.java.scalatech.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

//@Controller  @ResponseBody
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
@Profile("person3")
public class PersonController2 {
    
    private final PersonResporitory personResporitory;
  
    @GetMapping(value="/persons3")
    @ResponseBody
    List<Person> getPerson(){
        return personResporitory.findAll();
    }
    
}
