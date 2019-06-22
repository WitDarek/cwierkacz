package repository;

import dao.MessageDAO;
import dao.MessageDAOMap;
import model.Message;

public enum MessageRepository {
    INSTANCE;

    MessageDAO dao = new MessageDAOMap();

    MessageRepository(){

        dao.save(new Message("AAA","BBB",UserRepository.INSTANCE.getDAO().get("kazik")));
        dao.save(new Message("BBB","CCC",UserRepository.INSTANCE.getDAO().get("stefek")));
        dao.save(new Message("CCC","DDD",UserRepository.INSTANCE.getDAO().get("marek")));
    }

    public MessageDAO getDAO(){
        return dao;
    }
}
