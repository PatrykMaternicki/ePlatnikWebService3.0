package com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.DAO;

        import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoResultExceptionLogger;
        import com.aviaSoftware.ePlatnik.ePlatnikWebService.Loggers.NoUsedMethodLogger;
        import com.aviaSoftware.ePlatnik.ePlatnikWebService.Service.MenagerEmployeeService.Repository.Repository;
        import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;
        import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;

        import javax.persistence.EntityManager;
        import javax.persistence.NoResultException;
        import java.util.List;

public class EmployeeDAO implements Repository<Employee> {

    private EntityManager em;
    @Override
    public void create(Employee entity) {
        em.persist(entity);
        commit();
    }

    @Override
    public boolean update(Employee newRecords, long id) {
        try{
            Employee entity = em.createNamedQuery("Employee.Id", Employee.class).setParameter("personId", id).getSingleResult();
            entity.setPerson(newRecords.getPerson());
            entity.setContract(newRecords.getContract());
            entity.setBeforeEmployersList(newRecords.getBeforeEmployersList());
            entity.setCourseList(newRecords.getCourseList());
            em.persist(entity);
            return true;
        }
        catch (NoResultException e) {
            NoResultExceptionLogger.setException("Nie znalazlem takiego rekordu","w tabeli Pracownik");
            return false;
        }
    }

    @Override
    public Employee findWithId(long id) {
        try {
             Employee entity = em.createNamedQuery("Employee.Id", Employee.class).setParameter("personId", id).getSingleResult();
            return entity;
        } catch (NoResultException e) {
            return fillEntityExceptions(new Employee());
        }
    }

    @Override
    public List<Employee> findListUsingOwnerId(long id) {
        NoUsedMethodLogger.setException("FingListUsingOwnerId nie jest obsługiwana","w EmployeeDAO");
        return null;
    }

    @Override
    public void remove(long id) {
        em.getTransaction().begin();
        Course entity = em.find(Course.class, id);
        em.remove(entity);
    }

    @Override
    public void startDAO(EntityManager em) {
        this.em = em;
        startConnect();
    }

    @Override
    public void closeDAO() {
        closeConnect();
    }

    @Override
    public List<Employee> getAll() {
        List <Employee> entity = em.createNamedQuery("Employee.All", Employee.class).getResultList();
        return entity;
    }

    private Employee fillEntityExceptions(Employee entity) {
        return entity;
    }

    private void startConnect() {
        em.getTransaction().begin();
    }

    private void closeConnect() {
        em.close();
    }

    private void commit() {
        em.getTransaction().commit();
    }
}
