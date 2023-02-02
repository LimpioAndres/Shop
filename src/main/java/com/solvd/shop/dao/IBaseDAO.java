package com.solvd.shop.dao;

import com.solvd.shop.dao.mysql.ExceptionDAO;

import java.util.List;

public interface IBaseDAO <T,K>{

    void create (T a) throws ExceptionDAO;
    void update (T a) throws ExceptionDAO;
    void remove (T a) throws ExceptionDAO;
    List<T> selectAll() throws ExceptionDAO;
    T select(K id) throws ExceptionDAO;

    /*public interface IBaseDAO <T>{
        T getEntityById(long id);
        void updateEntity(T entity);
        T createEntity (T entity);
        void removeEntity(long id);
      }
     */
}
