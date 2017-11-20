package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.entityTest.ContractInfoTest;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups.HibernateSetup;
import org.junit.Before;
import org.junit.Test;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.testBuilder.ContextTestBuilder;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BonusTest extends HibernateSetup {

    private Bonus bonus;
    private ContextTestBuilder testBuilder;
    private EntityManager em;
    private Bonus testEntity;

    @Before
    public void setUp() {
        bonus = new Bonus();
        bonus.setItemBonus(testBuilder.testString);
        bonus.setPercentBonus(testBuilder.testDouble);
        bonus.setTypeBonus(testBuilder.testString);
        bonus.setValue(testBuilder.testDouble);
        super.createPU();
        em = super.getEm();
        em.getTransaction().begin();
        em.persist(bonus);
        em.getTransaction().commit();
        testEntity = em.find(Bonus.class, bonus.getId());
        em.close();
    }

    @Test
    public void getItemBonus_should_be_return_string() {
        assertThat("ItemBonus in Bonus is not String", bonus.getItemBonus(), is(String.class));
    }

    @Test
    public void testPU_should_be_return_itemBonus() {
        assertEquals("Column itembonus in table Bonus is not same in field itemBonus in Bonus object",
                testEntity.getItemBonus(),
                bonus.getItemBonus()
        );
    }

    @Test
    public void getPercentBonus_should_be_return_double() {
        assertThat("PercentBonus in Bonus is not double", bonus.getPercentBonus(), is(Double.class));
    }

    @Test
    public void testPU_should_be_return_percentBonus() {
        assertEquals("Column percentBonus in table Bonus is not same in field percentBonus in Bonus object",
                testEntity.getPercentBonus(),
                bonus.getPercentBonus()
        );
    }

    @Test
    public void getTypeBonus_should_be_return_string() {
        assertThat("TypeBonus in Bonus is not String", bonus.getTypeBonus(), is(String.class));
    }

    @Test
    public void testPU_should_be_return_typeBonus() {
        assertEquals("Column typeBonus in table Bonus is not same in field typeBonus in Bonus object",
                testEntity.getTypeBonus(),
                bonus.getTypeBonus()
        );
    }

    @Test
    public void getValue_should_be_return_double() {
        assertThat("ItemBonus in Bonus is not String", bonus.getValue(), is(Double.class));
    }

    @Test
    public void testPU_should_be_return_value() {
        assertEquals("Column value in table Bonus is not same in field value in Bonus object",
                testEntity.getValue(),
                bonus.getValue()
        );
    }

}
