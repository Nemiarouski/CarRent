package rent.hibernate.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    private Integer id;
    private String fullName;
    private List<Book> books;

    public Author() {
    }
    public Author(String fullName, List<Book> books) {
        this.fullName = fullName;
        this.books = books;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @OneToMany(targetEntity = Book.class, mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", books=" + books +
                '}';
    }
}