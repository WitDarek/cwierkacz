package dao;

import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOMap implements UserDAO {

    Map<String,User> users = new HashMap<>();

    @Override
    public User findByEmail(String email) {
        for(Map.Entry<String,User> e: users.entrySet())
        {
            if(e.getValue().getEmail().equals(email)){
                return e.getValue();
            }
        }return null;
    }

    @Override
    public void save(User obj) {
        users.put(obj.getLogin(),obj);
    }

    @Override
    public User get(String login) {
        return users.get(login);
    }

    @Override
    public void update(User obj) {
        users.put(obj.getLogin(),obj);
    }

    @Override
    public void delete(User obj) {
        users.remove(obj.getLogin());
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User get(long id) {
        return null;
    }
}
