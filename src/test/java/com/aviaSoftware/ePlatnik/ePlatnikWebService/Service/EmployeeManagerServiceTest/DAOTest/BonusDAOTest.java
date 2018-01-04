package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Collection.ListMethodCollection;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.BonusDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest.BonusTest;
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

public class BonusDAOTest {
    private Repository testDAO;
    private EntityManager em;
    private Bonus testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new Bonus();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new BonusDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void BeforeEmployersDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        Bonus foundEntity = new Bonus();
        System.out.println(testEntity.getId());
        System.out.println("ID :" + testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (Bonus) testDAO.findWithId(testEntity.getId());
        assertEquals("BonusDAO didn't delete a entity", "Entity not found", foundEntity.getTypeBonus());
    }

    @Ignore("Zacina sie")
    @Test
    public void BeforeEmployersDAO_should_be_add_entity() {
        Bonus testEntity = new Bonus();
        testDAO.create(testEntity);
        Bonus foundEntity = (Bonus) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        assertEquals("BonusDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }
    @Ignore ("Nie dziala jeszcze")
    @Test
    public void BeforeEmployersDAO_should_be_update_entity() {
        Bonus entityToUpdate = (Bonus) testDAO.findWithId(1);
        entityToUpdate.setTypeBonus(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate, 1);
        Bonus entityToUpdate1 = (Bonus) testDAO.findWithId(1);
        entityToUpdate.setItemBonus(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        Bonus entityAfterUpdate = (Bonus) testDAO.findWithId(1);
        System.out.println("typeBonus " + entityAfterUpdate.getTypeBonus() + "itemBonus" + entityAfterUpdate.getItemBonus());
        assertEquals("BonusDAO didn't updated",ContextTestBuilder.testString, entityAfterUpdate.getTypeBonus());

    }

    @Ignore ("Zacina sie")
    @Test
    public void BeforeEmployersDAO_should_be_find_using_id() {
        Bonus testEntity = new Bonus();
        testDAO.create(testEntity);
        Bonus foundedEntity = (Bonus) testDAO.findWithId(testEntity.getId());
        assertNotNull("BeforeEmployersDAO didn't found entity ", foundedEntity.getId());
    }

    @Ignore ("Zacina sie")
    @Test
    public void BeforeEmployersDAO_should_be_return_list(){
        testDAO.create(new Bonus());
        List entityList = new ArrayList<Bonus>();
        entityList = testDAO.getAll();
        assertTrue("In addressDAO in getAll something is wrong", ListMethodCollection.isEmptyList(entityList));
    }
}
