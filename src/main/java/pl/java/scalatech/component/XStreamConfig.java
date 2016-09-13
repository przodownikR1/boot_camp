package pl.java.scalatech.component;

import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class XStreamConfig {

    @Bean
    @ConditionalOnMissingBean
    XStream xstream(){
        XStream xstream =  new XStream();        
        return xstream;
    }
    
    
    @Bean
    @ConditionalOnBean(Converter.class)
    public Collection<Converter> conterters(XStream xstream , Collection<Converter> converters){    
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        converters.forEach(c->xstream.registerConverter(c));
        return converters;
        
}
    
}
