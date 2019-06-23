package repository;

import dao.UserDAO;
import dao.UserDAOJpa;
import dao.UserDAOMap;
import model.User;

public enum UserRepository {
    INSTANCE;

    private UserDAO dao = new UserDAOJpa();

    UserRepository(){
//        dao.save(new User("kazik","1234","kazik@.com"));
//        dao.save(new User("stefek","1234","stefek@.com"));
//        dao.save(new User("marek","1234","marek@.com"));
    }

    public UserDAO getDAO(){
        return dao;
    }
}
