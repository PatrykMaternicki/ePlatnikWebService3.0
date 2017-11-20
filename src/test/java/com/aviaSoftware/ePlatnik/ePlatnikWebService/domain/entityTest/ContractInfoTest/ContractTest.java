package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.Hibernate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ContractTest extends Mockito {

    private ContextTestBuilder testBuilder;
    private Bonus bonus;
    private ContractProperties contractProperties;
    private ArrayList<RaportOfWork> raportList;
    private Hibernate hibernate;
    private Contract persistedContract;
    private EntityManager em;
    private RaportOfWork raport;

    @Mock
    private Contract contract;


    @Before
    public void setUp() {
        hibernate = new Hibernate();
        hibernate.createPU();
        em = hibernate.getEm();
        em.getTransaction().begin();
        persistedContract = new Contract();
        bonus = new Bonus();
        raport = new RaportOfWork();
        contractProperties = new ContractProperties();
        raportList = new ArrayList<RaportOfWork>();
        persistedContract.addRaportOfWork(raport);
        persistedContract.addRaportOfWork(raport);
        persistedContract.setBonus(bonus);
        persistedContract.setContractProperties(contractProperties);
        persistedContract.setStartTimeContract(testBuilder.testString);
        persistedContract.setEndTimeContract(testBuilder.testString);
        persistedContract.setFreeDay(testBuilder.testInteger);
        persistedContract.setTypeContract(testBuilder.testString);
        em.persist(persistedContract);
        em.getTransaction().commit();


    }

    @After
    public void closeConnection() {
        em.close();
    }

    @Test
    public void getBonus_should_be_return_bonus_object() {
        when(contract.getBonus()).thenReturn(bonus);
        assertThat("Contract doesnt return bonus object", contract.getBonus(), is(Bonus.class));
    }

    @Test
    public void testPU_should_be_return_relationObject_bonus() {
        Query query = em.createQuery("select c.bonus from Contract as c where c.id=" + persistedContract.getId());
        Bonus foundedBonus = (Bonus) query.getSingleResult();
        Query findBonus = em.createQuery("select b from Bonus as b where b.id=" + foundedBonus.getId());
        Bonus testBonus = (Bonus) findBonus.getSingleResult();
        assertEquals("Relation is not exist with table BONUS and CONTRACT or keys is not equal",
                foundedBonus.getId(),
                testBonus.getId()
        );
    }

    @Test
    public void getRaportOfork_should_be_return_bonus_arrayList() {
        when(contract.getRaports()).thenReturn(raportList);
        assertThat("Contract doesnt return raportList object", contract.getRaports(), is(List.class));
    }

    @Test
    public void testPU_should_be_return_relationObject_raportOfWork() {
        Query query = em.createQuery("select c.id from Contract as c where c.id=" + persistedContract.getId());
        Long personKey = (Long) query.getSingleResult();
        Query queryToFindRaports = em.createQuery("select r from RaportOfWork as r where r.owner_raport = " + personKey);
        List<RaportOfWork> raports = queryToFindRaports.getResultList();
        assertEquals("Relation is not exist with table BONUS and CONTRACT or keys is not equal",
                personKey,
                raports.get(0).getOwner_raport().getId()
        );

    }

    @Test
    public void getContractProperties_should_be_return_contractProperties_object() {
        when(contract.getContractProperties()).thenReturn(contractProperties);
        assertThat("Contract doesn't return contract properties object", contract.getContractProperties(), is(ContractProperties.class));
    }

    @Test
    public void testPU_should_be_return_relationObject_contractProperties() {
        Query query = em.createQuery("select c.contractProperties from Contract as c where c.id=" + persistedContract.getId());
        ContractProperties foundedProperties = (ContractProperties) query.getSingleResult();
        Query queryFindContractPropertiesKey = em.createQuery("select cp.id from ContractProperties as cp where cp.id=" + foundedProperties.getId());
        Long wantedKey = (Long) queryFindContractPropertiesKey.getSingleResult();
        assertEquals("Relation is not exist with table CONTRACT_PROPERTIES and CONTRACT or keys is not equal",
                foundedProperties.getId(),
                wantedKey
        );
    }


    @Test
    public void getTypeContract_should_be_string() {
        when(contract.getTypeContract()).thenReturn(testBuilder.testString);
        assertThat("typeContract in contract is not string", contract.getTypeContract(), is(String.class));
    }

    @Test
    public void testPU_should_be_return_same_value_startTimeContract_in_testObject() {
        Query query = em.createQuery("select c.startTimeContract from Contract as c where c.id = " + persistedContract.getId());
        String foundedRecordStartTimeContract = (String) query.getSingleResult();
        assertEquals("Hibernate doesn't corectly set value to db, because record startTimeContract in TABLE" +
                        "is not equal to filed startTimeContract in Object contract ",
                foundedRecordStartTimeContract,
                persistedContract.getStartTimeContract());
    }


    @Test
    public void getStartTimeContract_should_be_string() {
        when(contract.getStartTimeContract()).thenReturn(testBuilder.testString);
        assertThat("StartTimeContract in contract is not string", contract.getStartTimeContract(), is(String.class));
    }

    @Test
    public void getEndTimeContract_should_be_string() {
        when(contract.getEndTimeContract()).thenReturn(testBuilder.testString);
        assertThat("EndTimeContract in contract is not string", contract.getEndTimeContract(), is(String.class));
    }


    @Test
    public void testPU_should_be_return_same_value_endTimeContract_in_testObject(){
        Query query = em.createQuery("select c.endTimeContract from Contract as c where c.id = " + persistedContract.getId());
        String foundedRecordEndTimeContract  = (String ) query.getSingleResult();
        assertEquals("Hibernate doesn't corectly set value to db, because record startTimeContract in TABLE" +
                        "is not equal to filed startTimeContract in Object contract ",
                foundedRecordEndTimeContract,
                persistedContract.getEndTimeContract());
    }

    @Test
    public void freeDay_should_be_string() {
        when(contract.getFreeDay()).thenReturn(testBuilder.testInteger);
        assertThat("FreeDay in contract is not integer", contract.getFreeDay(), is(Integer.class));
    }


    @Test
    public void testPU_should_be_return_same_value_freeDay_in_testObject(){
        Query query = em.createQuery("select c.freeDay from Contract as c where c.id = " + persistedContract.getId());
        int foundedRecordFreeDay  = (int) query.getSingleResult();
        assertEquals("Hibernate doesn't corectly set value to db, because record startTimeContract in TABLE" +
                        "is not equal to filed startTimeContract in Object contract ",
                foundedRecordFreeDay,
                persistedContract.getFreeDay());
    }

    @Test
    public void getJobPosition_should_be_string() {
        when(contract.getJobPosition()).thenReturn(testBuilder.testString);
        assertThat("JobPosition in contract is not string", contract.getJobPosition(), is(String.class));
    }

    @Test
    public void testPU_should_be_return_same_value_jobPosition_in_testObject(){
        Query query = em.createQuery("select c.jobPosition from Contract as c where c.id = " + persistedContract.getId());
        String foundedRecordJobPosition  = (String) query.getSingleResult();
        assertEquals("Hibernate doesn't corectly set value to db, because record startTimeContract in TABLE" +
                        "is not equal to filed startTimeContract in Object contract ",
                foundedRecordJobPosition,
                persistedContract.getJobPosition());
    }



}
