package pl.java.scalatech.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class Person implements Serializable{
   
 
    private static final long serialVersionUID = -7286634824785749082L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    
    private int age;
    
    private BigDecimal salary;
    

  
}
