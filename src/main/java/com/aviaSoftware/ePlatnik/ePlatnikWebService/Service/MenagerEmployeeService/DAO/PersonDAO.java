package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDAO implements Repository<Person> {

    @Override
    public void create(Person entity) {

    }

    @Override
    public void update(Person newRecords, long id) {

    }

    @Override
    public Person findWithId(long id) {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void startDAO(EntityManager em) {

    }

    @Override
    public void closeDAO() {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
