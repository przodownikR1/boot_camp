package pl.java.scalatech.component;

import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
@ConfigurationProperties(prefix="my")
public class DbProp {
    
    private URL dbUrl;

    private int port;
   
    private boolean active;
  
    private String test;
    
    private Resource location;
    
    
    
}
