package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import java.util.List;

public class PersonInformationDAO implements Repository<PersonInformation> {

	private EntityManager em;
	
    @Override
    public void create(PersonInformation entity) {
    	em.persist(entity);
        commit();
    }

    @Override
    public boolean update(PersonInformation newRecords, long id) {
    	 try{
             PersonInformation entity = em.createNamedQuery("PersonInformation.Id", PersonInformation.class).setParameter("personId", id).getSingleResult(); //personId - ?
             entity.setName(newRecords.getName());
             entity.setSurName(newRecords.getSurName());
             //entity.setDateOfBirth(newRecords.getDateOfBirth());
             entity.setPlaceOfBirth(newRecords.getPlaceOfBirth());
             entity.setOld(newRecords.getOld());
             entity.setPesel(newRecords.getPesel());
             em.persist(entity);
             return true;
         }
         catch (NoResultException e) {
             NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli address");
             return false;
         }
    }

    @Override
    public PersonInformation findWithId(long id) {
    	try {
            PersonInformation entity = em.createNamedQuery("PersonInformation.Id", PersonInformation.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new PersonInformation());
        }
    }
    
    private PersonInformation fillEntityExceptions(PersonInformation entity) {
        entity.setName("Entity not found");
        entity.setSurName("Entity not found");
        entity.setPlaceOfBirth("Entity not found");
        entity.setOld(0);
        entity.setPesel("Entity not found");
        return entity;
    }

    @Override
    public List<PersonInformation> findListUsingOwnerId(long id) {
    	 NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w AddressDAO");
         return null;
    }

    @Override
    public void remove(long id) {
    	 em.getTransaction().begin();
         PersonInformation entity = em.find(PersonInformation.class, id);
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
    
    private void startConnect() {
        em.getTransaction().begin();
    }

    private void closeConnect() {
        em.close();
    }

    @Override
    public List<PersonInformation> getAll() {
    	 startConnect();
         List<PersonInformation> entity = em.createNamedQuery("PersonInformation.All", PersonInformation.class).getResultList();
         closeConnect();
         return entity;
    }
    
    private void commit() {
        em.getTransaction().commit();
    }
}
