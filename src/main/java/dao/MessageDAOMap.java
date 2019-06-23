package dao;

import model.Message;
import model.User;

import java.util.*;

public class MessageDAOMap implements MessageDAO {

    Map<String,Message> messages = new HashMap<>();


    @Override
    public List<Message> findByAuthor(User user) {
        List<Message> result = new ArrayList<>();
        for(Map.Entry<String,Message> e: messages.entrySet()){
            if(e.getValue().getAuthor().equals(user)){
                result.add(e.getValue());
            }
        }return result;
    }

    @Override
    public void save(Message obj) {
        messages.put(obj.getTitle(),obj);
    }

    @Override
    public Message get(String title) {
        return messages.get(title);
    }

    @Override
    public void update(Message obj) {
        messages.put(obj.getTitle(),obj);
    }

    @Override
    public void delete(Message obj) {
        messages.remove(obj.getTitle());
    }

    @Override
    public List<Message> getAll() {
        return new ArrayList<>(messages.values());
    }

    @Override
    public Message get(long id) {
        return null;
    }
}
