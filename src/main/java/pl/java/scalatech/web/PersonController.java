package pl.java.scalatech.web;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import pl.java.scalatech.domain.Person;
import pl.java.scalatech.repository.PersonResporitory;

//@Controller  @ResponseBody
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class PersonController {
    
    private final PersonResporitory personResporitory;
  
    private final CounterService counterService;
    
    private final GaugeService gaugeService;
    
    @GetMapping(value="/persons")
    @ResponseBody
    List<Person> getPerson(){
        StopWatch sw = new StopWatch();
        sw.start();
        dupa();
        sw.stop();
        
        counterService.increment("licz_mi_person");
        gaugeService.submit("czaswykonania", sw.getTotalTimeMillis());
        return personResporitory.findAll();
    }
    @SneakyThrows
    private void dupa() {
        Thread.sleep(TimeUnit.SECONDS.toSeconds(3));
        System.out.println("slawek ....");
    }
    
}
