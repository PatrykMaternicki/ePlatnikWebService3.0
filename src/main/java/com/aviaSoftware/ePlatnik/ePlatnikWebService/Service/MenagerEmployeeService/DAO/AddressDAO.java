package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressDAO implements Repository<Address> {

    private EntityManager em;

    @Override
    public void create(Address entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public void update(Address newRecords, long id) {
        Address entity = em.createNamedQuery("Address.Id", Address.class).setParameter("personId", id).getSingleResult();
        entity.setStreet(newRecords.getStreet());
        entity.setPostalCode(newRecords.getPostalCode());
        entity.setFlatNumber(newRecords.getFlatNumber());
        entity.setCountry(newRecords.getCountry());
        entity.setCity(newRecords.getCity());
        em.persist(entity);


    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Address entity = em.find(Address.class, id);
        em.remove(entity);

    }

    private void commit() {
        em.getTransaction().commit();
    }

    @Override
    public Address findWithId(long id) {
        try {
            Address entity = em.createNamedQuery("Address.Id", Address.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Address());
        }

    }

    private Address fillEntityExceptions(Address entity) {
        entity.setCity("Entity not found");
        entity.setFlatNumber(0);
        entity.setPostalCode("Entity not found");
        entity.setStreet("Entity not found");
        return entity;

    }

    @Override
    public void startDAO(EntityManager em) {
        this.em = em;
        startConnect();
    }

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
    public List<Address> getAll() {
        startConnect();
        List<Address> entity = em.createNamedQuery("Address.All", Address.class).getResultList();
        closeConnect();
        return entity;
    }


}
