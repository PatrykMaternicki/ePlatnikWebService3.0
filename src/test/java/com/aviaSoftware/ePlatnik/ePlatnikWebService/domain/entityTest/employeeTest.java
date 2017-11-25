package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest;

import java.util.ArrayList;
import java.util.List;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@RunWith(MockitoJUnitRunner.class)
public class employeeTest extends Mockito {

    private Hibernate hibernate;
    private Employee persistedEmployee;
    private EntityManager em;
    private Person person;
    private Contract contract;
    private ArrayList<BeforeEmployers> list;
    private ArrayList<Course> courseList;
    private ArrayList<RaportOfWork> raportList;
    @Mock
    private Employee employee;

    @Before
    public void setUp() {
        persistedEmployee = new Employee();
        hibernate = new Hibernate();
        hibernate.createPU();
        em = hibernate.getEm();
        em.getTransaction().begin();
        person = new Person();
        contract = new Contract();
        list = new ArrayList<BeforeEmployers>();
        courseList = new ArrayList<Course>();
        persistedEmployee.setContract(contract);
        persistedEmployee.setPerson(person);
        BeforeEmployers beforeEmployersTest1 = new BeforeEmployers();
        BeforeEmployers beforeEmployersTest2 = new BeforeEmployers();
        persistedEmployee.addBeforeEmployers(beforeEmployersTest1);
        persistedEmployee.addBeforeEmployers(beforeEmployersTest2);
        persistedEmployee.addCourse(new Course());
        persistedEmployee.addCourse(new Course());
        em.persist(persistedEmployee);
        em.getTransaction().commit();
    }

    @After
    public void closeConnection() {
        em.close();
    }

    @Test
    public void when_call_method_in_employee_getPerson_then_return_Person() {
        when(employee.getPerson()).thenReturn(person);
        assertThat("Employee doesnt return Person", employee.getPerson(), is(Person.class));
    }

    @Test
    public void testPU_should_be_return_person_object() {
        Query query = em.createQuery("select e.person from Employee as e where e.id = " + persistedEmployee.getId());
        Person personEntity = (Person) query.getSingleResult();
        assertThat("Table EMPLOYEE don't have a relationship with table PERSON", personEntity, is(Person.class));
    }


    @Test
    public void when_call_method_in_employee_getContract_then_return_contract() {
        when(employee.getContract()).thenReturn(contract);
        assertThat("Employee doesnt return contract", employee.getContract(), is(Contract.class));
    }

    @Test
    public void testPU_should_be_return_contract_object() {
        Query query = em.createQuery("select e.contract from Employee as e where e.id = " + persistedEmployee.getId());
        Contract contractEntity = (Contract) query.getSingleResult();
        assertThat("Table EMPLOYEE don't have a relationship with table CONTRACT", contractEntity, is(Contract.class));
    }


    @Test
    public void when_call_method_in_empployee_getBeforeEmloyeeList_then_return_beforeEmployersList() {
        when(employee.getBeforeEmployersList()).thenReturn(list);
        assertThat("Before Employers list doesnt return", employee.getBeforeEmployersList(), is(List.class));
    }

    @Test
    public void table_employee_have_a_relationship_one_to_many_with_table_BEFORE_EMPLOYERS() {
        Query query = em.createQuery("select bf from BeforeEmployers as bf where bf.ownerBeforeEmployers = " + persistedEmployee.getId());
        List<BeforeEmployers> list = query.getResultList();
        assertEquals("Table EMPLOYEE don't have a relationship oneToMany with table BEFORE_EMPLOYERS",
                persistedEmployee.getId(),
                list.get(0).getOwnerBeforeEmployers().getId());
    }


    @Test
    public void when_call_method_in_empployee_getBeforeEmloyeeList_then_return_courseList() {
        when(employee.getCourseList()).thenReturn(courseList);
        assertThat("Course list doesnt return", employee.getCourseList(), is(List.class));
    }

    @Test
    public void employee_have_relationship_one_to_many_to_table_course(){
        Query query = em.createQuery("select c from Course as c where c.ownerCourse = " + persistedEmployee.getId());
        List<Course> list = query.getResultList();
        assertEquals("Table EMPLOYEE don't have a relationship oneToMany with table BEFORE_EMPLOYERS",
                persistedEmployee.getId(),
                list.get(0).getOwnerCourse().getId());
    }

}
