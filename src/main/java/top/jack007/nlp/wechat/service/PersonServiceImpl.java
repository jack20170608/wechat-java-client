package top.jack007.nlp.wechat.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jack007.nlp.wechat.domain.Person;
import top.jack007.nlp.wechat.repositories.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Override
  public List<Person> loadAll() {
    return personRepository.findAll();
  }

  @Override
  @Transactional
  public void initData() {
    Set<Person> dummyData = Sets.newHashSet();
    dummyData.add(new Person("Jack", "Fang"));
    dummyData.add(new Person("Lucy", "Deng"));
    dummyData.add(new Person("Leo", "Fang"));
    personRepository.save(dummyData);
  }

}
