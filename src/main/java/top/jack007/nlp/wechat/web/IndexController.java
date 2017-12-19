package top.jack007.nlp.wechat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jack007.nlp.wechat.domain.Person;
import top.jack007.nlp.wechat.service.PersonService;

import java.util.List;

/**
 * Created by mbart on 28.02.2016.
 */
@Controller
public class IndexController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/")
    public String showIndex(Model model) {
        List<Person> personList = personService.loadAll();

        model.addAttribute("personList", personList);

        return "index"; // return index.html Template
    }

    @RequestMapping("/initData")
    @ResponseBody
    public String initData() {
        personService.initData();
        return "init data successfully";
    }
}
