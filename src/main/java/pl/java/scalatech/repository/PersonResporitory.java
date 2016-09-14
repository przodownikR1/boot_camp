package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.java.scalatech.domain.Person;
@RepositoryRestResource(collectionResourceRel="person",path="osoby")
public interface PersonResporitory extends JpaRepository<Person, Long>{

}
