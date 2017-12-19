package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.Bonus;

import javax.persistence.EntityManager;
import java.util.List;

public class BonusDAO implements Repository<Bonus> {

    @Override
    public void create(Bonus entity) {

    }

    @Override
    public void update(Bonus newRecords, long id) {

    }

    @Override
    public Bonus findWithId(long id) {
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
    public List<Bonus> getAll() {
        return null;
    }
}
