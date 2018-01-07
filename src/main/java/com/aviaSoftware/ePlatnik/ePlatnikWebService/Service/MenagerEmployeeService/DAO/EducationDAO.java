package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EducationDAO implements Repository<Education> {

    private EntityManager em;
    @Override
    public void create(Education entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Education newRecords, long id) {
        try{
            Education entity = em.createNamedQuery("Education.Id", Education.class).setParameter("personId", id).getSingleResult();
            entity.setEducateThePerson(newRecords.getEducateThePerson());
            entity.setEndYear(newRecords.getEndYear());
            entity.setNameSchool(newRecords.getNameSchool());
            entity.setStartYear(newRecords.getStartYear());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Education");
            return false;
        }
    }

    @Override
    public Education findWithId(long id) {
        try {
            Education entity = em.createNamedQuery("Education.Id", Education.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Education());
        }
    }

    @Override
    public List<Education> findListUsingOwnerId(long id) {
        try {
            List<Education> entityList = em.createNamedQuery("Education.Id", Education.class).setParameter("personId", id).getResultList();
            return entityList;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Education");
            return null;
        }
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Education entity = em.find(Education.class, id);
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
    public List<Education> getAll() {
        List<Education> entityList = em.createNamedQuery("Education.getAll", Education.class).getResultList();
        return entityList;
    }

    private Education fillEntityExceptions(Education education) {
        education.setStartYear(0);
        education.setNameSchool("Entity not found");
        education.setEndYear(0);
        return education;
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
