package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ContractDAO implements Repository<Contract> {

    private EntityManager em;
    @Override
    public void create(Contract entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Contract newRecords, long id) {
        try{
            Contract entity = em.createNamedQuery("Contract.Id", Contract.class).setParameter("contractId", id).getSingleResult();
            entity.setEndTimeContract(newRecords.getEndTimeContract());
            entity.setTypeContract(newRecords.getTypeContract());
            entity.setFreeDay(newRecords.getFreeDay());
            entity.setStartTimeContract(newRecords.getStartTimeContract());
            entity.setContractProperties(newRecords.getContractProperties());
            entity.setBonus(newRecords.getBonus());
            entity.setRaports(newRecords.getRaports());
            entity.setJobPosition(newRecords.getJobPosition());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Contract");
            return false;
        }
    }

    @Override
    public Contract findWithId(long id) {
        try {
            Contract entity = em.createNamedQuery("Contract.Id", Contract.class).setParameter("contractId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Contract());
        }
    }

    @Override
    public List<Contract> findListUsingOwnerId(long id) {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w ContractDAO");
        return null;
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Contract entity = em.find(Contract.class, id);
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
    public List<Contract> getAll() {
        startConnect();
        List<Contract> entity = em.createNamedQuery("Contract.All", Contract.class).getResultList();
        closeConnect();
        return entity;
    }

    private void commit() {
        em.getTransaction().commit();
    }

    private Contract fillEntityExceptions(Contract entity) {
        entity.setRaports(null);
        entity.setBonus(null);
        entity.setContractProperties(null);
        entity.setStartTimeContract("Entity not found");
        entity.setFreeDay(0);
        entity.setTypeContract("Entity not found");
        entity.setEndTimeContract("Entity not found");
        entity.setJobPosition("Entity not found");
        return entity;
    }

    private void startConnect() {
        em.getTransaction().begin();
    }

    private void closeConnect() {
        em.close();
    }


}
