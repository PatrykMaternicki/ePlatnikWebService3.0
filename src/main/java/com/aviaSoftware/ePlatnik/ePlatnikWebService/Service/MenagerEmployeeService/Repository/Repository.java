package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository;

public interface Repository<T> {
    void create(T entity);
    void remove(T entity);
    void update(T entity);
    void findWithId(T entity,int id);
    void delete(T entity,int id);
}
