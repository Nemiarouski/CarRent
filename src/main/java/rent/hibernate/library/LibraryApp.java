package rent.hibernate.library;

import org.hibernate.Session;
import rent.hibernate.library.entity.Author;
import rent.hibernate.library.entity.Book;
import rent.hibernate.library.utils.HibernateUtil;

public class LibraryApp {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();

        Author author = new Author();
        author.setFullName("Bruce Willis");

        Book book = new Book();
        book.setBookName("War and Peace");

        Book book1 = new Book();
        book1.setBookName("Cloud Atlas");

        book.setAuthor(author);
        book1.setAuthor(author);

        session.save(author);
        session.save(book);
        session.save(book1);

        session.getTransaction().commit();
        session.close();

    }
}