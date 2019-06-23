package dao;

import model.Message;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MessageDAOJpa implements MessageDAO {

    private EntityManagerFactory ef = Persistence.createEntityManagerFactory("cwierkacz");
    private EntityManager em = ef.createEntityManager();

    @Override
    public List<Message> findByAuthor(User user) {

        return em.createQuery("SELECT m from Message m where author=:author_id")
        .setParameter("author_id", user).getResultList();

    }

    @Override
    public void save(Message obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public Message get(String key) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m from Message m WHERE title =:param", Message.class);
        query.setParameter("param", key);
        Message m = (Message) query.getSingleResult();
        em.getTransaction().commit();
        return m;
    }

    @Override
    public void update(Message obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Message obj) {
    em.getTransaction().begin();
    em.remove(obj);
    em.getTransaction().commit();
    }

    @Override
    public List<Message> getAll() {
        return em.createQuery("From Message").getResultList();
    }

    @Override
    public Message get(long id) {
        return em.find(Message.class, id);
    }
}
