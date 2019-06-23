package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserDAOJpa implements UserDAO {

    private EntityManagerFactory ef = Persistence.createEntityManagerFactory("cwierkacz");
    private EntityManager em = ef.createEntityManager();

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void save(User obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    @Override
    public User get(String key) {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT m from User m WHERE login =:param", User.class);
        query.setParameter("param", key);
        User m = (User) query.getSingleResult();
        em.getTransaction().commit();
        return m;
    }

    @Override
    public void update(User obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void delete(User obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("From User").getResultList();
    }

    @Override
    public User get(long id) {
        return em.find(User.class, id);
    }
}
