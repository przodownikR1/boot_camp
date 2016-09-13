package pl.java.scalatech.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/start")
    String hello(Model model ){
        model.addAttribute("hello", LocalTime.now().toSecondOfDay());
        return "hello";
    }
    
    
}
