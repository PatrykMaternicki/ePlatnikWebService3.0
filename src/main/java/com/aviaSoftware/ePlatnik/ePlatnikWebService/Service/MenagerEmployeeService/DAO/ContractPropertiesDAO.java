package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class ContractPropertiesDAO implements Repository<ContractPropertiesDAO> {

    @Override
    public void create(ContractPropertiesDAO entity) {

    }

    @Override
    public void update(ContractPropertiesDAO newRecords, long id) {

    }

    @Override
    public ContractPropertiesDAO findWithId(long id) {
        return null;
    }

    @Override
    public void remove(long id) {

    }

    @Override
    public void startDAO(EntityManager em) {

    }

    @Override
    public void closeDAO() {

    }

    @Override
    public List<ContractPropertiesDAO> getAll() {
        return null;
    }
}
