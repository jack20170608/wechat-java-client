package top.jack007.nlp.wechat.service;

import top.jack007.nlp.wechat.domain.Person;

import java.util.List;


public interface PersonService {
  List<Person> loadAll();

  void initData();
}
