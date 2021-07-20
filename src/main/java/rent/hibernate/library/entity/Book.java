package rent.hibernate.library.entity;

import javax.persistence.*;

@Entity
public class Book {

    private Integer id;
    private String bookName;
    private Author author;

    public Book() {
    }
    public Book(Integer id, String bookName, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @ManyToOne()
    @JoinColumn(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                '}';
    }
}