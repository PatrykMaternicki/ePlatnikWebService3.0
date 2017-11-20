package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BEFORE_EMPLOYERS")
public class BeforeEmployers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameEmployers;
    private int startYearWork;
    private int endYearWork;
    private int endMonthWork;
    private int startMonthWork;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name="EMPLOYEE_ID")
    private Employee ownerBeforeEmployers;

    public String getNameEmployers() {
        return nameEmployers;
    }

    public void setNameEmployers(String nameEmployers) {
        this.nameEmployers = nameEmployers;
    }

    public int getStartYearWork() {
        return startYearWork;
    }

    public void setStartYearWork(int startWork) {
        this.startYearWork = startWork;
    }

    public int getEndYearWork() {
        return endYearWork;
    }

    public void setEndYearWork(int endWork) {
        this.endYearWork = endWork;
    }

    public int getEndMonthWork() {
        return endMonthWork;
    }

    public void setEndMonthWork(int endMontWorkh) {
        this.endMonthWork = endMontWorkh;
    }

    public int getStartMonthWork() {
        return startMonthWork;
    }

    public void setStartMonthWork(int startMonthWork) {
        this.startMonthWork = startMonthWork;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getOwnerBeforeEmployers() {
        return ownerBeforeEmployers;
    }

    public void setOwnerBeforeEmployers(Employee ownerBeforeEmployers) {
        this.ownerBeforeEmployers = ownerBeforeEmployers;
    }
}
