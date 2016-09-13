package pl.java.scalatech.component;

import java.net.URL;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@ConfigurationProperties(prefix="my")
//@PropertySources({    
//@PropertySource("classpath:tomcat.properties"),
//@PropertySource("classpath:db.properties")
//})
public class DbProp {
     
    private URL dbUrl;
   
    private int port;
   
    private boolean active;
    
  //  @Size(min=1,max=10)
    private String test;
    
    private Resource location;
    
    
    
}
