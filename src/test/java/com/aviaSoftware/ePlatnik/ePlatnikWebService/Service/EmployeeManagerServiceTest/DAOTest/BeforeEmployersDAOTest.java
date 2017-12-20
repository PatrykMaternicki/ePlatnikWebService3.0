package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Collection.ListMethodCollection;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.BeforeEmployersDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BeforeEmployersDAOTest {
    private Repository testDAO;
    private EntityManager em;
    private BeforeEmployers testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new BeforeEmployers();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new BeforeEmployersDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void BeforeEmployersDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        BeforeEmployers foundEntity = new BeforeEmployers();
        System.out.println(testEntity.getId());
        System.out.println("ID :" + testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (BeforeEmployers) testDAO.findWithId(testEntity.getId());
        assertEquals("BeforeEmployersDAO didn't delete a entity", "Entity not found", foundEntity.getNameEmployers());
    }

    @Test
    public void BeforeEmployersDAO_should_be_add_entity() {
        BeforeEmployers testEntity = new BeforeEmployers();
        testDAO.create(testEntity);
        BeforeEmployers foundEntity = (BeforeEmployers) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        assertEquals("BeforeEmployersDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Test
    public void BeforeEmployersDAO_should_be_update_entity() {
        BeforeEmployers entityToUpdate = (BeforeEmployers) testDAO.findWithId(1);
        entityToUpdate.setNameEmployers(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate, 1);
        BeforeEmployers entityToUpdate1 = (BeforeEmployers) testDAO.findWithId(1);
        entityToUpdate.setEndYearWork(ContextTestBuilder.testInteger);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        BeforeEmployers entityAfterUpdate = (BeforeEmployers) testDAO.findWithId(1);
        System.out.println("nameEmployers " + entityAfterUpdate.getNameEmployers() + "endYearWork" + entityAfterUpdate.getEndYearWork());
        assertEquals("BeforeEmployersDAO didn't updated",ContextTestBuilder.testString, entityAfterUpdate.getNameEmployers());

    }

    @Test
    public void BeforeEmployersDAO_should_be_find_using_id() {
        BeforeEmployers testEntity = new BeforeEmployers();
        testDAO.create(testEntity);
        BeforeEmployers foundedEntity = (BeforeEmployers) testDAO.findWithId(testEntity.getId());
        assertNotNull("BeforeEmployersDAO didn't found entity ", foundedEntity.getId());
    }

    @Test
    public void BeforeEmployersDAO_should_be_return_list(){
        testDAO.create(new BeforeEmployers());
        List<BeforeEmployers> entityList = new ArrayList<BeforeEmployers>();
        entityList = testDAO.getAll();
        assertTrue("In addressDAO in getAll something is wrong", ListMethodCollection.isEmptyList(entityList));
    }
}
