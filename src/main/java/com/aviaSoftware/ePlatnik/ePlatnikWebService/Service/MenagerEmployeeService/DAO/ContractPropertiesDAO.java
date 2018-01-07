package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ContractPropertiesDAO implements Repository<ContractProperties> {
    private EntityManager em;

    @Override
    public void create(ContractProperties entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(ContractProperties newRecords, long id) {
        try{
            ContractProperties entity = em.createNamedQuery("ContractProperties.Id", ContractProperties.class).setParameter("contractId", id).getSingleResult();
            entity.setHadInvalidStatus(newRecords.isHadInvalidStatus());
            entity.setHadRetiredStatus(newRecords.isHadInvalidStatus());
            entity.setHadStudentStatus(newRecords.isHadStudentStatus());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli ContractProperties");
            return false;
        }
    }

    @Override
    public ContractProperties findWithId(long id) {
        try {
            ContractProperties entity = em.createNamedQuery("ContractProperties.Id", ContractProperties.class).setParameter("contractId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new ContractProperties());
        }
    }

    @Override
    public List<ContractProperties> findListUsingOwnerId(long id) {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w ContractPropertiesDAO");
        return null;
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        ContractProperties entity = em.find(ContractProperties.class, id);
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
    public List<ContractProperties> getAll() {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w ContractPropertiesDAO");
        return null;
    }

    private ContractProperties fillEntityExceptions(ContractProperties entity) {
        entity.setHadStudentStatus(false);
        entity.setHadRetiredStatus(false);
        entity.setHadInvalidStatus(false);
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
