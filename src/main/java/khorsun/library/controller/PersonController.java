package khorsun.library.controller;

import khorsun.library.dao.PersonDAO;
import khorsun.library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDAO personDAO;
    @Autowired
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("person",personDAO.index());
        return "people/index";
    }
    @GetMapping("/new")
    public String getFormForCreatingPerson(@ModelAttribute("person")Person person){
        return "people/new";
    }
    @PostMapping()
    public String createPerson(@ModelAttribute("person")Person person){
        personDAO.create(person);
        return "redirect:/people";
    }
}
