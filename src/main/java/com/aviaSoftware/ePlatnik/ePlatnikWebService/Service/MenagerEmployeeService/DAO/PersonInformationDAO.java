package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.PersonInformation;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonInformationDAO implements Repository<PersonInformation> {


    @Override
    public void create(PersonInformation entity) {

    }

    @Override
    public void update(PersonInformation newRecords, long id) {

    }

    @Override
    public PersonInformation findWithId(long id) {
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
    public List<PersonInformation> getAll() {
        return null;
    }
}
