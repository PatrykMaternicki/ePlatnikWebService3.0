package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Collection.ListMethodCollection;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.CourseDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.EducationDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EducationDAOTest {

    private Repository testDAO;
    private EntityManager em;
    private Education testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new Education();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new EducationDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }


    @Test
    public void EducationDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        Education foundEntity = new Education();
        System.out.println(testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (Education) testDAO.findWithId(testEntity.getId());
        assertEquals("EducationDAO didn't delete a entity", "Entity not found", foundEntity.getNameSchool());
    }

    @Ignore("Zacina sie")
    @Test
    public void EducationDAO_should_be_add_entity() {
        Education testEntity = new Education();
        testDAO.create(testEntity);
        Education foundEntity = (Education) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        TestCase.assertEquals("EducationDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Ignore ("Nie dziala jeszcze")
    @Test
    public void EducationDAO_should_be_update_entity() {
        Education entityToUpdate = (Education) testDAO.findWithId(1);
        entityToUpdate.setNameSchool(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate, 1);
        Education entityToUpdate1 = (Education) testDAO.findWithId(1);
        entityToUpdate.setStartYear(ContextTestBuilder.testInteger);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        Education entityAfterUpdate = (Education) testDAO.findWithId(1);
        System.out.println("getNameSchool: " + entityAfterUpdate.getNameSchool());
        TestCase.assertEquals("EducationDAO didn't updated",ContextTestBuilder.testInteger, entityAfterUpdate.getStartYear());
    }

    @Ignore ("Cos tu sie zacina")
    @Test
    public void EducationDAO_should_be_find_using_id() {
        Education testEntity = new Education();
        testDAO.create(testEntity);
        Education foundedEntity = (Education) testDAO.findWithId(testEntity.getId());
        assertNotNull("EducationDAO didn't found entity ", foundedEntity.getId());
    }

    @Ignore ("Zacina sie")
    @Test
    public void EducationDAO_should_be_return_list(){
        testDAO.create(new Education());
        List<Education> entityList = new ArrayList<Education>();
        entityList = testDAO.getAll();
        assertTrue("In EducationDAO in getAll something is wrong", ListMethodCollection.isEmptyList(entityList));
    }
}
