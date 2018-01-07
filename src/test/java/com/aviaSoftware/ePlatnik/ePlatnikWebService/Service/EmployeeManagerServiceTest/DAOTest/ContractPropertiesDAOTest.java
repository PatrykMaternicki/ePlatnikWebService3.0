package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.ContractPropertiesDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class ContractPropertiesDAOTest {

    private Repository testDAO;
    private EntityManager em;
    private ContractProperties testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new ContractProperties();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new ContractPropertiesDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void ContractPropertiesDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        ContractProperties foundEntity = new ContractProperties();
        System.out.println(testEntity.getId());
        System.out.println("ID :" + testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (ContractProperties) testDAO.findWithId(testEntity.getId());
        assertEquals("ContractPropertiesDAO didn't delete a entity", false, foundEntity.isHadStudentStatus());
    }

    @Ignore("Zacina sie")
    @Test
    public void ContractPropertiesDAO_should_be_add_entity() {
        ContractProperties testEntity = new ContractProperties();
        testDAO.create(testEntity);
        ContractProperties foundEntity = (ContractProperties) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        assertEquals("ContractPropertiesDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Ignore ("Nie dziala jeszcze")
    @Test
    public void ContractPropertiesDAO_should_be_update_entity() {
        ContractProperties entityToUpdate = (ContractProperties) testDAO.findWithId(1);
        entityToUpdate.setHadInvalidStatus(ContextTestBuilder.testBoolean);
        testDAO.update(entityToUpdate, 1);
        ContractProperties entityToUpdate1 = (ContractProperties) testDAO.findWithId(1);
        entityToUpdate.setHadInvalidStatus(ContextTestBuilder.testBoolean);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        ContractProperties entityAfterUpdate = (ContractProperties) testDAO.findWithId(1);
        System.out.println("isHadInvalidStatus " + entityAfterUpdate.isHadInvalidStatus());
        assertEquals("ContractPropertiesDAO didn't updated",ContextTestBuilder.testBoolean, entityAfterUpdate.isHadInvalidStatus());
    }

    @Ignore ("Zacina sie")
    @Test
    public void ContractPropertiesDAO_should_be_find_using_id() {
        ContractProperties testEntity = new ContractProperties();
        testDAO.create(testEntity);
        ContractProperties foundedEntity = (ContractProperties) testDAO.findWithId(testEntity.getId());
        assertNotNull("ContractPropertiesDAO didn't found entity ", foundedEntity.getId());
    }
}
