package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Course.Id", query = "select c from Course as c where c.ownerCourse=:personId ")
})
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameCourse;
    private int expiredTime;
    private boolean isRequiredToWork;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee ownerCourse;

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public boolean isRequiredToWork() {
        return isRequiredToWork;
    }

    public void setRequiredToWork(boolean isRequiredToWork) {
        this.isRequiredToWork = isRequiredToWork;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getOwnerCourse() {
        return ownerCourse;
    }

    public void setOwnerCourse(Employee ownerCourse) {
        this.ownerCourse = ownerCourse;
        if (!ownerCourse.getCourseList().contains(this)) {
            ownerCourse.getCourseList().add(this);
        }
    }
}
