package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

        import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
        import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;

        import javax.persistence.EntityManager;
        import java.util.List;

public class EmployeeDAO implements Repository<Employee> {

    @Override
    public void create(Employee entity) {

    }

    @Override
    public boolean update(Employee newRecords, long id) {
        return false;
    }

    @Override
    public Employee findWithId(long id) {
        return null;
    }

    @Override
    public List<Employee> findListUsingOwnerId(long id) {
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
    public List<Employee> getAll() {
        return null;
    }
}
