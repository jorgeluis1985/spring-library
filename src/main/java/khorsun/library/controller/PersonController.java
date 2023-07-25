package khorsun.library.controller;

import khorsun.library.dao.BookDAO;
import khorsun.library.dao.PersonDAO;
import khorsun.library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;
    @Autowired
    public PersonController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("person",personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String showOnePerson(@PathVariable("id") int id,Model model){
        model.addAttribute("person",personDAO.show(id));
        model.addAttribute("book",bookDAO.showBookForPerson(id));

        return "people/show";
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
