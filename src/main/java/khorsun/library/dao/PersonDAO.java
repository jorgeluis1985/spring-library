package khorsun.library.dao;

import khorsun.library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("select spring_app.public.person.name, " +
                        "spring_app.public.person.year from spring_app.public.person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public void create(Person person){
        jdbcTemplate.update("insert into spring_app.public.person( name, year) values(?,?)",
                person.getName(),person.getYear());
    }

    public Person show(int id){
         return jdbcTemplate.query("select spring_app.public.person.name," +
                "spring_app.public.person.year from spring_app.public.person where person_id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

}
