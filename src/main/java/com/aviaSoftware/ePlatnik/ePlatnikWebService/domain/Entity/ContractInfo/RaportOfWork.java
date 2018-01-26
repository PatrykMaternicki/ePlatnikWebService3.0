package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo;

import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "RAPORT_OF_WORK")
@NamedQueries({
        @NamedQuery(name = "RaportOfWork.Id", query = "select rpo from RaportOfWork as rpo where rpo.id=:personId "),
        @NamedQuery(name = "RaportOfWork.getAll", query = "select rpo from RaportOfWork as rpo"),
        @NamedQuery(name= "RaportOfWork.getAllOwnedWithContract", query="select rpo from RaportOfWork as rpo where rpo.owner_raport=:contractId")
})
public class RaportOfWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Month;
    private int year;
    private int workDays;
    private int workHours;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNER_ID")
    private Contract owner_raport;

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Contract getOwner_raport() {
        return owner_raport;
    }

    public void setOwner_raport(Contract owner_raport) {
        this.owner_raport = owner_raport;
        if (!owner_raport.getRaports().contains(this)) {
            owner_raport.getRaports().add(this);
        }
    }
}
