package dao;

import model.Message;
import model.User;

import java.util.List;

public interface MessageDAO extends DAO<Message> {

    List<Message> findByAuthor (User user);
}
