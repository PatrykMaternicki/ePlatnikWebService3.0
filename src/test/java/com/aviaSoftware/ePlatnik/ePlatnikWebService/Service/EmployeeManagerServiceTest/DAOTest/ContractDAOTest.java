package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Collection.ListMethodCollection;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.ContractDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ContractDAOTest {
    private Repository testDAO;
    private EntityManager em;
    private Contract testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new Contract();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new ContractDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void ContractDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        Contract foundEntity = new Contract();
        System.out.println(testEntity.getId());
        System.out.println("ID :" + testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (Contract) testDAO.findWithId(testEntity.getId());
        assertEquals("ContractDAO didn't delete a entity", "Entity not found", foundEntity.getStartTimeContract());
    }

    @Ignore("Zacina sie")
    @Test
    public void ContractDAO_should_be_add_entity() {
        Contract testEntity = new Contract();
        testDAO.create(testEntity);
        Contract foundEntity = (Contract) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        assertEquals("ContractDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Ignore ("Nie dziala jeszcze")
    @Test
    public void ContractDAO_should_be_update_entity() {
        Contract entityToUpdate = (Contract) testDAO.findWithId(1);
        entityToUpdate.setTypeContract(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate, 1);
        Contract entityToUpdate1 = (Contract) testDAO.findWithId(1);
        entityToUpdate.setEndTimeContract(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        Contract entityAfterUpdate = (Contract) testDAO.findWithId(1);
        System.out.println("endTimeContract " + entityAfterUpdate.getEndTimeContract() + "typeContract" + entityAfterUpdate.getTypeContract());
        assertEquals("ContractDAO didn't updated",ContextTestBuilder.testString, entityAfterUpdate.getStartTimeContract());
    }

    @Ignore ("Zacina sie")
    @Test
    public void ContractDAO_should_be_find_using_id() {
        Contract testEntity = new Contract();
        testDAO.create(testEntity);
        Contract foundedEntity = (Contract) testDAO.findWithId(testEntity.getId());
        assertNotNull("ContractDAO didn't found entity ", foundedEntity.getId());
    }

    @Ignore ("Zacina sie")
    @Test
    public void ContractDAO_should_be_return_list(){
        testDAO.create(new Contract());
        List entityList = new ArrayList<Contract>();
        entityList = testDAO.getAll();
        assertTrue("In ContractDAO in getAll something is wrong", ListMethodCollection.isEmptyList(entityList));
    }
}
