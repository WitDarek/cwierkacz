package repository;

import dao.UserDAO;
import dao.UserDAOMap;
import model.User;

public enum UserRepository {
    INSTANCE;

    private UserDAO dao = new UserDAOMap();

    UserRepository(){
        dao.save(new User("kazik","1234","kazik@.com"));
        dao.save(new User("stefek","1234","stefek@.com"));
        dao.save(new User("marek","1234","marek@.com"));
    }

    public UserDAO getDAO(){
        return dao;
    }
}
