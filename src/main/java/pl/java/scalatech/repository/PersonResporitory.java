package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Person;

public interface PersonResporitory extends JpaRepository<Person, Long>{

}
