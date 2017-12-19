package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;

import javax.persistence.EntityManager;
import java.util.List;

public class BeforeEmployersDAO implements Repository<BeforeEmployers> {

    @Override
    public void create(BeforeEmployers entity) {

    }

    @Override
    public void update(BeforeEmployers newRecords, long id) {

    }

    @Override
    public BeforeEmployers findWithId(long id) {
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
    public List<BeforeEmployers> getAll() {
        return null;
    }
}
