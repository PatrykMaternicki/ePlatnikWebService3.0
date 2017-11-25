package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo.*;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.BeforeEmployers;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Course;
import com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo.Person;

import javax.persistence.Entity;


@Entity
@Table(name = "EMPLOYEE")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID", nullable = true)
    private Person person = new Person();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRACT_ID", nullable = true)
    private Contract contract = new Contract();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerBeforeEmployers")
    private List<BeforeEmployers> BeforeEmployersList = new ArrayList<BeforeEmployers>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerCourse")
    private List<Course> courseList = new ArrayList<Course>();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<BeforeEmployers> getBeforeEmployersList() {
        return BeforeEmployersList;
    }

    public void setBeforeEmployersList(List<BeforeEmployers> beforeEmployersList) {
        BeforeEmployersList = beforeEmployersList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addCourse(Course course) {
        courseList.add(course);
        if (course.getOwnerCourse() != this) {
            course.setOwnerCourse(this);
        }
    }
    public void addBeforeEmployers (BeforeEmployers beforeEmployers){
            BeforeEmployersList.add(beforeEmployers);
            if (beforeEmployers.getOwnerBeforeEmployers() != this) {
                beforeEmployers.setOwnerBeforeEmployers(this);
            }
        }
    }

