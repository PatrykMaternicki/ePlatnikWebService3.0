package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MysqlDBSetup implements iHibernateSetup<EntityManager>
{
    @Override
    public EntityManager createPU() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
        return entityManager;
    }
}
