package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.RaportOfWork;

import javax.persistence.EntityManager;
import java.util.List;

public class RaportOfWorkDAO implements Repository<RaportOfWork> {

    @Override
    public void create(RaportOfWork entity) {

    }

    @Override
    public boolean update(RaportOfWork newRecords, long id) {
        return false;
    }

    @Override
    public RaportOfWork findWithId(long id) {
        return null;
    }

    @Override
    public List<RaportOfWork> findListUsingOwnerId(long id) {
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
    public List<RaportOfWork> getAll() {
        return null;
    }
}
