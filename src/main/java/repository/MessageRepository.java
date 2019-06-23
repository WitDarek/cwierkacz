package repository;

import dao.MessageDAO;
import dao.MessageDAOJpa;
import dao.MessageDAOMap;
import model.Message;

public enum MessageRepository {
    INSTANCE;

    MessageDAO dao = new MessageDAOJpa();

    MessageRepository(){

        //zakomentowane aby hiberneit nie dodawał kolejnych
//        dao.save(new Message("AAA","BBB",UserRepository.INSTANCE.getDAO().get("kazik")));
//        dao.save(new Message("BBB","CCC",UserRepository.INSTANCE.getDAO().get("stefek")));
//        dao.save(new Message("CCC","DDD",UserRepository.INSTANCE.getDAO().get("marek")));
    }

    public MessageDAO getDAO(){
        return dao;
    }
}
