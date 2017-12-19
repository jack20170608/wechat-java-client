package top.jack007.nlp.wechat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import top.jack007.nlp.wechat.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long>{
}
