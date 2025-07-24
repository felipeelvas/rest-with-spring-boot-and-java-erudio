package br.com.felipeelvas.repository;

import br.com.felipeelvas.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
