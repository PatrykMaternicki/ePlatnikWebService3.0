package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.ContractProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class ContractPropertiesTest extends HibernateSetup {

    private EntityManager em;
    private ContractProperties contractProperties;
    private ContractProperties entityTest;
    private ContextTestBuilder testBuilder;

    @Before
    public void setUp() {
        super.createPU();
        em = super.getEm();
        em.getTransaction().begin();
        contractProperties = new ContractProperties();
        contractProperties.setHadInvalidStatus(testBuilder.testBoolean);
        contractProperties.setHadRetiredStatus(testBuilder.testBoolean);
        contractProperties.setHadStudentStatus(testBuilder.testBoolean);
        em.persist(contractProperties);
        em.getTransaction().commit();
        entityTest = em.find(ContractProperties.class, contractProperties.getId());
        em.close();
    }

    @Test
    public void isHadInvalidStatus_should_be_return_boolean() {
        assertThat("isHadInvaidStatus is not boolean", contractProperties.isHadInvalidStatus(), is(Boolean.class));
    }

    @Test
    public void testPU_should_be_return_isHadInvalidStatus() {
        assertEquals("Column HADINVALIDSTATUS in table CONTRACT_PROPERTIES is not same in field hadInvalidStatus in ContractProperties object",
                entityTest.isHadInvalidStatus(),
                contractProperties.isHadInvalidStatus()
        );
    }

    @Test
    public void isHadRetiredStatus_should_be_return_boolean() {
        assertThat("isHadRetiredStatus is not boolean", contractProperties.isHadRetiredStatus(), is(Boolean.class));
    }

    @Test
    public void testPU_should_be_return_isHadRetiredtatus() {
        assertEquals("Column HADRETIREDSTATUS in table CONTRACT_PROPERTIES is not same in field hadRetiredStatus in ContractProperties object",
                entityTest.isHadRetiredStatus(),
                contractProperties.isHadRetiredStatus()
        );
    }

    @Test
    public void isHadStudentStatus() {
        assertThat("isHadStudentStatus is not boolean", contractProperties.isHadStudentStatus(), is(Boolean.class));
    }

    @Test
    public void testPU_should_be_return_isHadStudentStatus() {
        assertEquals("Column HADSTUDENTSTATUS in table CONTRACT_PROPERTIES is not same in field hadStudentStatus in ContractProperties object",
                entityTest.isHadStudentStatus(),
                contractProperties.isHadStudentStatus()
        );
    }
}
