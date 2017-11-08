package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Setups;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class HibernateSetup {
    private EntityManager em;

    public void createPU(){
        em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }
}
