package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.EmployeeManagerServiceTest.DAOTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.CourseDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CourseDAOTest {

    private Repository testDAO;
    private EntityManager em;
    private Course testEntity;

    @Before
    public void Setup() {
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        testEntity = new Course();
        System.out.println("TESTSTSTSTS" + testEntity.getId());
        testDAO = new CourseDAO();
        testDAO.startDAO(em);
    }

    @After
    public void close() {
        testDAO.closeDAO();
    }

    @Test
    public void CourseDAO_should_be_remove_entity() {
        testDAO.create(testEntity);
        Course foundEntity = new Course();
        System.out.println(testEntity.getId());
        testDAO.remove(testEntity.getId());
        foundEntity = (Course) testDAO.findWithId(testEntity.getId());
        assertEquals("addressDAO didn't delete a entity", "Entity not found", foundEntity.getNameCourse());
    }

    @Ignore("Zacina sie")
    @Test
    public void CourseDAO_should_be_add_entity() {
        Course testEntity = new Course();
        testDAO.create(testEntity);
        Course foundEntity = (Course) testDAO.findWithId(testEntity.getId());
        System.out.println("test : " + testEntity.getId() + " founded entity :" + foundEntity.getId());
        TestCase.assertEquals("ContractPropertiesDAO didn't add a entity", testEntity.getId(), foundEntity.getId());
    }

    @Ignore ("Nie dziala jeszcze")
    @Test
    public void CourseDAO_should_be_update_entity() {
        Course entityToUpdate = (Course) testDAO.findWithId(1);
        entityToUpdate.setNameCourse(ContextTestBuilder.testString);
        testDAO.update(entityToUpdate, 1);
        Course entityToUpdate1 = (Course) testDAO.findWithId(1);
        entityToUpdate.setExpiredTime(ContextTestBuilder.testInteger);
        testDAO.update(entityToUpdate1, 1);
        System.out.println("ID:" + 1);
        Course entityAfterUpdate = (Course) testDAO.findWithId(1);
        System.out.println("setNameCourse: " + entityAfterUpdate.getNameCourse());
        TestCase.assertEquals("CourseDAO didn't updated",ContextTestBuilder.testInteger, entityAfterUpdate.getExpiredTime());
    }

    @Ignore ("Cos tu sie zacina")
    @Test
    public void CourseDAO_should_be_find_using_id() {
        Course testEntity = new Course();
        testDAO.create(testEntity);
        Course foundedEntity = (Course) testDAO.findWithId(testEntity.getId());
        assertNotNull("AddressDAO didn't found entity ", foundedEntity.getId());
    }
}
