package khorsun.library.model;

public class Book {
    private int bookId;
    private String name;
    private String author;
    private int year;

    private int personId;

    public Book() {
    }

    public Book(int bookId, String name, String author, int year,int personId) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.year = year;
        this.personId= personId;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
