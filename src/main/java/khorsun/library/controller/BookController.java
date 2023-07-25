package khorsun.library.controller;

import khorsun.library.dao.BookDAO;
import khorsun.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookDAO bookDAO;
    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("book", bookDAO.index());
        return "book/index";
    }
    @GetMapping("/new")
    public String getFormForCreatingBook(@ModelAttribute("book")Book book){

        return "book/new";
    }
    @PostMapping()
    public String createBook(@ModelAttribute("book") Book book){
        bookDAO.create(book);

        return "redirect:/book";
    }
}
