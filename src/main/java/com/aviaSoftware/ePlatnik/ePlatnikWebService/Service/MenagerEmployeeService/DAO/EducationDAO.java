package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Education;

import javax.persistence.EntityManager;
import java.util.List;

public class EducationDAO implements Repository<Education> {

    @Override
    public void create(Education entity) {

    }

    @Override
    public boolean update(Education newRecords, long id) {
        return false;
    }

    @Override
    public Education findWithId(long id) {
        return null;
    }

    @Override
    public List<Education> findListUsingOwnerId(long id) {
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
    public List<Education> getAll() {
        return null;
    }
}
