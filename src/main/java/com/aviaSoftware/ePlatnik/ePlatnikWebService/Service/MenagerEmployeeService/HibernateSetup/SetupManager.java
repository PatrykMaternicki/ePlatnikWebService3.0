package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup;

import javax.persistence.EntityManager;

public class SetupManager {
    public EntityManager getEm(HibernateProperties.typePU hibernateTypePU){
        switch(hibernateTypePU){
            case hsqlDBPU:{
               return new HsqlDBSetup().createPU();
            }
            case mysqlDBPU:{
                return new MysqlDBSetup().createPU();

            }
            default:{
                throw new EnumConstantNotPresentException(HibernateProperties.typePU.class, "Not found type hibernateSetup");
            }
        }
    }
}
