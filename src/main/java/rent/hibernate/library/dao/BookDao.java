package rent.hibernate.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rent.hibernate.library.entity.Book;
import rent.hibernate.phonelist.utils.HibernateUtil;
import java.util.List;

public class BookDao {

    public void create(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    public Book read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Book book = session.get(Book.class, id);
            transaction.commit();
            return book;
        }
    }

    public void update(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        }
    }

    public void delete(Book book) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        }
    }

    public List<Book> show() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Book").list();
        }
    }
}