package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO implements Repository<Course> {

    @Override
    public void create(Course entity) {

    }

    @Override
    public boolean update(Course newRecords, long id) {
        return false;
    }

    @Override
    public Course findWithId(long id) {
        return null;
    }

    @Override
    public List<Course> findListUsingOwnerId(long id) {
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
    public List<Course> getAll() {
        return null;
    }
}
