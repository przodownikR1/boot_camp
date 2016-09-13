package pl.java.scalatech;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;
import pl.java.scalatech.web.PersonController;

@RunWith(SpringRunner.class)
@Slf4j
@Ignore
@WebMvcTest(controllers=PersonController.class) //without starting a full HTTP server
public class PersonControllerTest {
    
    @MockBean
    private PersonResporitory personRepository;
    
    @Autowired
    MockMvc mockMvc;
    

    
    @Test
    public void shouldBootstap() throws Exception{
        //given
        given(personRepository.findOne(any(Long.class))).willReturn(Person.builder().name("slawek").age(20).build());
        //when //then
        mockMvc.perform(get("/persons/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(content().json("{'name':'slawek','age':'20'}"));
        
        
       
       
    }

}
