package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import javax.persistence.*;

@Entity
@Table(name = "EDUCATION")
@NamedQueries({
        @NamedQuery(name = "Education.Id", query = "select e from Education as e where e.id=:personId "),
        @NamedQuery(name = "Education.getAll", query = "select e from Education as e")
})
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameSchool;
    private int startYear;
    private int endYear;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EDUCATION_OWNER_ID")
    private Person educateThePerson;

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getEducateThePerson() {
        return educateThePerson;
    }

    public void setEducateThePerson(Person educateThePerson) {
        this.educateThePerson = educateThePerson;
        if (!educateThePerson.getEducationList().contains(this)) {
            educateThePerson.getEducationList().add(this);
        }
    }
}
