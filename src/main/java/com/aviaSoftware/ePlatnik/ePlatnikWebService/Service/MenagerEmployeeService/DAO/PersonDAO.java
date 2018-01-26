package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class PersonDAO implements Repository<Person> {
    private EntityManager em;
    @Override
    public void create(Person entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Person newRecords, long id) {
        try{
            Person entity = em.createNamedQuery("Person.Id", Person.class).setParameter("personId", id).getSingleResult();
            entity.setEducationList(newRecords.getEducationList());
            entity.setInformation(newRecords.getInformation());
            entity.setAdress(newRecords.getAdress());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Osoba");
            return false;
        }
    }

    @Override
    public Person findWithId(long id) {
        try {
            Person entity = em.createNamedQuery("Employee.Id", Person.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Person());
        }
    }

    @Override
    public List<Person> findListUsingOwnerId(long id) {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w EmployeeDAO");
        return null;
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Person entity = em.find(Person.class, id);
        em.remove(entity);
    }

    @Override
    public void startDAO(EntityManager em) {
        this.em = em;
        startConnect();
    }

    @Override
    public void closeDAO() {
        closeConnect();
    }

    @Override
    public List<Person> getAll() {
        List <Person> entity = em.createNamedQuery("Person.All", Person.class).getResultList();
        return entity;
    }

    private Person fillEntityExceptions(Person entity) {
        return entity;
    }

    private void startConnect() {
        em.getTransaction().begin();
    }

    private void closeConnect() {
        em.close();
    }

    private void commit() {
        em.getTransaction().commit();
    }
}
