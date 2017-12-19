package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public interface Repository<T> {
    public void create(T entity);
    public void update(T newRecords,long id);
    public T  findWithId(long id);
    public void remove(long id);
    public void startDAO (EntityManager em);
    public void closeDAO();
    public List<T> getAll();

}
