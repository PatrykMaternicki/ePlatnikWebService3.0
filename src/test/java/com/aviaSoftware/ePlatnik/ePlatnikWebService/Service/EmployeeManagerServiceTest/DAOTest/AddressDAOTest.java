package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Collection.ListMethodCollection;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.AddressDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Address;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOTest {
    private Repository testDAO;
    private EntityManager em;
    private Address testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new Address();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new AddressDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void AddressDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        Address foundEntity = new Address();
        System.out.println(testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (Address) testDAO.findWithId(testEntity.getId());
        assertEquals("addressDAO didn't delete a entity", "Entity not found", foundEntity.getStreet());
    }

    @Test
    public void AddressDAO_should_be_add_entity() {
        testDAO.create(testEntity);
        Address foundEntity = (Address) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        assertEquals("AddressDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Ignore ("Recznie dziala, razem cos tu sie zacina")
    @Test
    public void AddressDAO_should_be_update_entity() {
        Address entityToUpdate1 = (Address) testDAO.findWithId(1);
        entityToUpdate1.setCountry("Jakis");
        testDAO.update(entityToUpdate1, 1);
        Address entityToUpdate = (Address) testDAO.findWithId(1);
        entityToUpdate.setCity("Poand");
        testDAO.update(entityToUpdate, 1);
        System.out.println("ID:" + 1);
        Address entityAfterUpdate = (Address) testDAO.findWithId(1);
        assertEquals("AddressDAP didn't updated", "Poand", entityAfterUpdate.getCity());
    }

    @Ignore ("Cos tu sie zacina")
    @Test
    public void AddressDAO_should_be_find_using_id() {
        Address testEntity = new Address();
        testDAO.create(testEntity);
        Address foundedEntity = (Address) testDAO.findWithId(testEntity.getId());
        assertNotNull("AddressDAO didn't found entity ", foundedEntity.getId());
    }


    @Ignore ("Cos tu sie zacina")
    @Test
    public void AddressDAO_should_be_return_list(){
        testDAO.create(new Address());
        List<Address> entityList = new ArrayList<Address>();
        entityList = testDAO.getAll();
        assertTrue("In addressDAO in getAll something is wrong", ListMethodCollection.isEmptyList(entityList));


    }
}
