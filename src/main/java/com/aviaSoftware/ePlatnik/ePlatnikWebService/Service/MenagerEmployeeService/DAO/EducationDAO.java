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
    public void update(Education newRecords, long id) {

    }

    @Override
    public Education findWithId(long id) {
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
