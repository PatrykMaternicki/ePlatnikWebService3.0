package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.DAOProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.FactoryDAOImpl;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO.iFactoryDAO;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.HibernateProperties;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.SetupManager;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.HibernateSetup.iHibernateSetup;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;

import javax.persistence.EntityManager;

public class ManagerEmployeeService {
    private EntityManager em;
    private iFactoryDAO factoryDAO;
    public ManagerEmployeeService (HibernateProperties.typePU typePU){
        runPU(typePU);
        runFactoryDAO();
    }
    private  void runPU(HibernateProperties.typePU typePU){
        em = new SetupManager().getEm(typePU);
    }
    private void runFactoryDAO(){
        factoryDAO = new FactoryDAOImpl();
    }
    public Repository callService (DAOProperties.Type typeDAO){
        factoryDAO.buildProduct(typeDAO);
        factoryDAO.getProduct().startDAO(em);
        return factoryDAO.getProduct();

    }

}
