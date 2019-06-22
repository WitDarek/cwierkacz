package dao;

import model.User;

public interface UserDAO extends DAO<User> {
        User findByEmail(String email);


}
