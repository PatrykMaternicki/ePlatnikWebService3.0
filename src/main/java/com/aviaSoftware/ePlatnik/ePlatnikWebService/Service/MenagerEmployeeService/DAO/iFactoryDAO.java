package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;

public interface iFactoryDAO {
    public Repository getProduct();
    public void buildProduct(DAOProperties.Type typeDAO);
}
