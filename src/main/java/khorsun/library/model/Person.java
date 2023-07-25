package khorsun.library.model;

public class Person {
    private int personId;
    private int bookId;
    private String name;
    private int year;

    public Person() {
    }

    public Person(int personId, int bookId, String name, int year) {
        this.personId = personId;
        this.bookId = bookId;
        this.name = name;
        this.year = year;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
