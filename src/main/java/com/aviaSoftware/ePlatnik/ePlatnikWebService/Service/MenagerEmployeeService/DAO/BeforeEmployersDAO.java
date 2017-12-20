package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class BeforeEmployersDAO implements Repository<BeforeEmployers> {

    private EntityManager em;

    @Override
    public void create(BeforeEmployers entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(BeforeEmployers newRecords, long id) {
        try {
            BeforeEmployers entityList = em.createNamedQuery("BeforeEmployers.get", BeforeEmployers.class).setParameter("personId", id).getSingleResult();
            entityList.setEndMonthWork(newRecords.getEndMonthWork());
            entityList.setEndYearWork(newRecords.getEndYearWork());
            entityList.setNameEmployers(newRecords.getNameEmployers());
            entityList.setStartMonthWork(newRecords.getStartMonthWork());
            entityList.setStartYearWork(newRecords.getStartYearWork());
            em.persist(entityList);
            return true;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu", "w tabeli byli pracodawcy");
            return false;
        }
    }

    @Override
    public BeforeEmployers findWithId(long id) {
        try {
            BeforeEmployers entity = em.createNamedQuery("BeforeEmployers.get", BeforeEmployers.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new BeforeEmployers());
        }
    }

    private BeforeEmployers fillEntityExceptions(BeforeEmployers beforeEmployers) {
        beforeEmployers.setStartYearWork(0);
        beforeEmployers.setStartMonthWork(0);
        beforeEmployers.setNameEmployers("Entity not found");
        beforeEmployers.setEndYearWork(0);
        beforeEmployers.setEndMonthWork(0);
        return beforeEmployers;
    }

    @Override
    public List<BeforeEmployers> findListUsingOwnerId(long id) {
        try {
            List<BeforeEmployers> entityList = em.createNamedQuery("BeforeEmployers.get", BeforeEmployers.class).setParameter("personId", id).getResultList();
            return entityList;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znaleziono rekordow", "w bylych pracodawcach");
            return null;
        }
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        List<BeforeEmployers> entityList = em.createNamedQuery("BeforeEmployers.get", BeforeEmployers.class).setParameter("personId", id).getResultList();
        for (BeforeEmployers entity : entityList){
            em.remove(entity);
        }
    }

    @Override
    public List<BeforeEmployers> getAll() {
        List<BeforeEmployers> entityList = em.createNamedQuery("BeforeEmployers.getAll", BeforeEmployers.class).getResultList();
        return entityList;
    }

    @Override
    public void startDAO(EntityManager em) {
        this.em = em;
        startConnect();
    }

    private void startConnect() {
        em.getTransaction().begin();
    }

    @Override
    public void closeDAO() {
        closeConnect();

    }

    private void closeConnect() {
        em.close();
    }

    private void commit() {
        em.getTransaction().commit();
    }

}
