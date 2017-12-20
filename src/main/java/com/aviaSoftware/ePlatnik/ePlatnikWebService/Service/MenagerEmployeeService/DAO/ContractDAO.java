package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Contract;

import javax.persistence.EntityManager;
import java.util.List;

public class ContractDAO implements Repository<Contract> {

    @Override
    public void create(Contract entity) {

    }

    @Override
    public boolean update(Contract newRecords, long id) {
        return false;
    }

    @Override
    public Contract findWithId(long id) {
        return null;
    }

    @Override
    public List<Contract> findListUsingOwnerId(long id) {
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
    public List<Contract> getAll() {
        return null;
    }
}
