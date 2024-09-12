package br.com.chfb.rest_api_aula.repositorys;

import br.com.chfb.rest_api_aula.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
