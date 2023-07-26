package khorsun.library.dao;

import khorsun.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index(){
        return jdbcTemplate.query("select name,author,year from spring_app.public.book",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void create(Book book){
        jdbcTemplate.update("insert into spring_app.public.book(name, author, year) VALUES(?,?,?)",
                book.getName(),book.getAuthor(),book.getYear());

    }

    public List<Book> showBookForPerson(int id){
        return jdbcTemplate.query("select spring_app.public.book.name,spring_app.public.book.author," +
                        "spring_app.public.book.year from spring_app.public.book inner join" +
                        " spring_app.public.person p on book.person_id = p.person_id  " +
                        "where p.person_id=?",
                new Object[]{id},new BeanPropertyRowMapper<>(Book.class));
    }


}
