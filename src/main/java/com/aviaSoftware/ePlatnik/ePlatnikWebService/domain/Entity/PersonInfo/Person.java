package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Person.All", query = "select p from Person as p"),
        @NamedQuery(name = "Person.findAddress", query = "select p.adress from Person as p where p.adress=:id"),
        @NamedQuery(name = "Person.findPersonInformation", query = "select p.information from Person as p where p.information=:id")
})
@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address adress = new Address();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_INFORMATION_ID", nullable = false)
    private PersonInformation information = new PersonInformation();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educateThePerson")
    private List<Education> educationList = new ArrayList<Education>();

    public Address getAdress() {
        return adress;
    }

    public void setAdress(Address adress) {
        this.adress = adress;
    }

    public PersonInformation getInformation() {
        return information;
    }

    public void setInformation(PersonInformation information) {
        this.information = information;
    }

    public void addEducation(Education education) {
        educationList.add(education);
        if (education.getEducateThePerson() != this) {
            education.setEducateThePerson(this);
        }
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
