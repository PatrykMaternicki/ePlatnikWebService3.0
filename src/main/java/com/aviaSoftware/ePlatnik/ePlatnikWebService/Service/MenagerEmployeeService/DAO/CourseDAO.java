package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class CourseDAO implements Repository<Course> {

    private EntityManager em;
    @Override
    public void create(Course entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Course newRecords, long id) {
        try{
            Course entity = em.createNamedQuery("Course.Id", Course.class).setParameter("personId", id).getSingleResult();
            entity.setOwnerCourse(newRecords.getOwnerCourse());
            entity.setExpiredTime(newRecords.getExpiredTime());
            entity.setNameCourse(newRecords.getNameCourse());
            entity.setRequiredToWork(newRecords.isRequiredToWork());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Course");
            return false;
        }
    }

    @Override
    public Course findWithId(long id) {
        try {
            Course entity = em.createNamedQuery("Course.Id", Course.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Course());
        }
    }

    @Override
    public List<Course> findListUsingOwnerId(long id) {
        try {
            List<Course> entityList = em.createNamedQuery("Course.Id", Course.class).setParameter("personId", id).getResultList();
            return entityList;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Course");
            return null;
        }
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Course entity = em.find(Course.class, id);
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
    public List<Course> getAll() {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w CourseDAO");
        return null;
    }

    private Course fillEntityExceptions(Course entity) {
        entity.setRequiredToWork(false);
        entity.setNameCourse("Entity not found");
        entity.setExpiredTime(0);
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
