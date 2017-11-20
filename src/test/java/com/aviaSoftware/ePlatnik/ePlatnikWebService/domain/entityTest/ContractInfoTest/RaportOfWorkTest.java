package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import javax.persistence.EntityManager;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RaportOfWorkTest extends HibernateSetup{

    private EntityManager em;
    private RaportOfWork raport;
    private RaportOfWork entityTest;
    private ContextTestBuilder testBuilder;


    @Before
    public void setUp() {
		super.createPU();
		em = super.getEm();
		em.getTransaction().begin();
        raport = new RaportOfWork();
        raport.setMonth(testBuilder.testInteger);
        raport.setWorkDays(testBuilder.testInteger);
        raport.setWorkHours(testBuilder.testInteger);
        raport.setYear(testBuilder.testInteger);
        em.persist(raport);
        em.getTransaction().commit();
        entityTest = em.find(RaportOfWork.class, raport.getId());
        em.close();
    }

    @Test
    public void getMonth_should_be_return_integer() {
        assertThat("Month in raportOfWork is not integer", raport.getMonth(), is(Integer.class));
    }

    @Test
    public void testPU_should_be_return_month(){
        assertEquals("Column MONTH in table RAPORT_OF_WORK is not same month in object RaportOfWork ",
                entityTest.getMonth(),
                raport.getMonth()
                );
    }

    @Test
    public void getWorkDays_should_be_return_integer() {
        assertThat("WorkDays in raportOfWork is not integer", raport.getWorkDays(), is(Integer.class));
    }

    @Test
    public void testPU_should_be_return_workDays(){
        assertEquals("Column WORKDAYS in table RAPORT_OF_WORK is not same workDays in object RaportOfWork ",
                entityTest.getWorkDays(),
                raport.getWorkDays()
        );
    }


    @Test
    public void getWorkHours_should_be_return_integer() {
        assertThat("WorkHours in raportOfWork is not integer", raport.getWorkHours(), is(Integer.class));
    }

    @Test
    public void testPU_should_be_return_workHours(){
        assertEquals("Column WORKHOURS in table RAPORT_OF_WORK is not same workHours in object RaportOfWork ",
                entityTest.getWorkHours(),
                raport.getWorkHours()
        );
    }


    @Test
    public void getYear_should_be_return_integer() {
        assertThat("Year in raportOfWork is not integer", raport.getYear(), is(Integer.class));
    }

    @Test
    public void testPU_should_be_return_year(){
        assertEquals("Column YEAR in table RAPORT_OF_WORK is not same year in object RaportOfWork ",
                entityTest.getYear(),
                raport.getYear()
        );
    }

}
