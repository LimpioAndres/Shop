package com.solvd.shop.dao;

import java.util.List;

public interface IBaseDAO <T,K>{

    void create (T a);
    void update (T a);
    void remove (T a);
    List<T> selectAll();
    T select(K id);

    /*public interface IBaseDAO <T>{
        T getEntityById(long id);
        void updateEntity(T entity);
        T createEntity (T entity);
        void removeEntity(long id);
      }
     */
}
