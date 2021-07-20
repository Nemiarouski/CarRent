package rent.hibernate.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import rent.hibernate.library.entity.Author;
import rent.hibernate.phonelist.utils.HibernateUtil;
import java.util.List;

public class AuthorDao {

    public void create(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        }
    }

    public Author read(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Author author = session.get(Author.class, id);
            transaction.commit();
            return author;
        }
    }

    public void update(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(author);
            transaction.commit();
        }
    }

    public void delete(Author author) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        }
    }

    public List<Author> show() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Author").list();
        }
    }
}