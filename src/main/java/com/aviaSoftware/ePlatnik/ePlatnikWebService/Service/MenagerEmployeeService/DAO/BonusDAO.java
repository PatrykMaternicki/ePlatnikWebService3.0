package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class BonusDAO implements Repository<Bonus> {

    private EntityManager em;
    @Override
    public void create(Bonus entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Bonus newRecords, long id) {
        try {
            Bonus entityList = em.createNamedQuery("Bonus.Id", Bonus.class).setParameter("contractId", id).getSingleResult();
            entityList.setItemBonus(newRecords.getItemBonus());
            entityList.setTypeBonus(newRecords.getTypeBonus());
            entityList.setPercentBonus(newRecords.getPercentBonus());
            entityList.setValue(newRecords.getValue());
            em.persist(entityList);
            return true;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu", "w tabeli bonus");
            return false;
        }
    }

    @Override
    public Bonus findWithId(long id) {
        try {
            Bonus entity = em.createNamedQuery("Bonus.Id", Bonus.class).setParameter("contractId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Bonus());
        }
    }

    private Bonus fillEntityExceptions(Bonus bonus) {
        bonus.setPercentBonus(0.0);
        bonus.setTypeBonus("Entity not found");
        bonus.setItemBonus("Entity not found");
        bonus.setValue(0.0);
        return bonus;
    }

    @Override
    public List<Bonus> findListUsingOwnerId(long id) {
        try {
            List<Bonus> entityList = em.createNamedQuery("Bonus.Id", Bonus.class).setParameter("contractId", id).getResultList();
            return entityList;
        } catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znaleziono rekordow", "w bonusach");
            return null;
        }
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        List<Bonus> entityList = em.createNamedQuery("Bonus.Id", Bonus.class).setParameter("contractId", id).getResultList();
        for (Bonus entity : entityList){
            em.remove(entity);
        }
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

    private void closeConnect() {
        em.close();
    }

    @Override
    public List<Bonus> getAll() {
        List<Bonus> entityList = em.createNamedQuery("Bonus.getAll", Bonus.class).getResultList();
        return entityList;
    }

    private void commit() {
        em.getTransaction().commit();
    }

    private void startConnect() {
        em.getTransaction().begin();
    }

}
