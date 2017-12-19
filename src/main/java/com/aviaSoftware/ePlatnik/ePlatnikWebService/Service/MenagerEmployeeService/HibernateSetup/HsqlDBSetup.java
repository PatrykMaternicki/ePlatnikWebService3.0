package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HsqlDBSetup implements iHibernateSetup<EntityManager> {

    public EntityManager  createPU() {
        EntityManager em = Persistence.createEntityManagerFactory("testPU").createEntityManager();
        return em;
    }


}
