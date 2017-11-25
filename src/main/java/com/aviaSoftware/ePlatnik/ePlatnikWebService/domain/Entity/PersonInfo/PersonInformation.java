package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Course.Id", query = "select pi from PersonInformation as pi where pi.id=:id")
})
@Table(name = "PERSON_INFORMATION")
public class PersonInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_INFORMATION_ID", unique = true, nullable = true)
    private long id;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "information")
    private Person person;
    private String name;
    private String surName;
    private Date dateOfBirth;
    private String placeOfBirth;
    private int Old;
    private String pesel;

    public PersonInformation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getOld() {
        return Old;
    }

    public void setOld(int old) {
        Old = old;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
