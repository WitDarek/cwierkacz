package dao;

import java.util.List;

public interface DAO <T>{

    void save(T obj);
    T get(String key);
    void update(T obj);
    void delete(T obj);
    List<T> getAll();
    T get(long id);
}
