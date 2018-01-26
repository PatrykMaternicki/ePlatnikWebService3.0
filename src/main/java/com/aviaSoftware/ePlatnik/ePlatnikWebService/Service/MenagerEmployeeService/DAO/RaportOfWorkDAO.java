package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class RaportOfWorkDAO implements Repository<RaportOfWork> {
    private EntityManager em;
    @Override
    public void create(RaportOfWork entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(RaportOfWork newRecords, long id) {
        try{
            RaportOfWork entity = em.createNamedQuery("RaportOfWork.Id", RaportOfWork.class).setParameter("personId", id).getSingleResult();
            entity.setOwner_raport(newRecords.getOwner_raport());
            entity.setMonth(newRecords.getMonth());
            entity.setWorkDays(newRecords.getWorkDays());
            entity.setWorkHours(newRecords.getWorkHours());
            entity.setYear(newRecords.getYear());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Raporty pracy");
            return false;
        }
    }

    @Override
    public RaportOfWork findWithId(long id) {
        try {
            RaportOfWork entity = em.createNamedQuery("RaportOfWork.Id", RaportOfWork.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new RaportOfWork());
        }
    }

    @Override
    public List<RaportOfWork> findListUsingOwnerId(long id) {
        try {
            List<RaportOfWork> entityList = em.createNamedQuery("RaportOfWork.getAllOwnedWithContract", RaportOfWork.class).setParameter("contractId", id).getResultList();
            return entityList;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znaleziono rekordow", "w raportach pracy");
            return null;
        }
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        RaportOfWork entity = em.find(RaportOfWork.class, id);
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
    public List<RaportOfWork> getAll() {
        List <RaportOfWork> entity = em.createNamedQuery("Employee.All", RaportOfWork.class).getResultList();
        return entity;
    }

    private RaportOfWork fillEntityExceptions(RaportOfWork entity) {
        entity.setYear(0);
        entity.setWorkHours(0);
        entity.setWorkDays(0);
        entity.setMonth(0);
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
