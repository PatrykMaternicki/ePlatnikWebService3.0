package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
@Table (name="CONTRACT_PROPERTIES")
@NamedQueries({
        @NamedQuery(name = "ContractProperties.Id", query = "select cp from ContractProperties as cp where cp.id=:contractId")
})
public class ContractProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean hadStudentStatus;
    private boolean hadRetiredStatus;
    private boolean hadInvalidStatus;

    public boolean isHadStudentStatus() {
        return hadStudentStatus;
    }

    public void setHadStudentStatus(boolean hadStudentStatus) {
        this.hadStudentStatus = hadStudentStatus;
    }

    public boolean isHadRetiredStatus() {
        return hadRetiredStatus;
    }

    public void setHadRetiredStatus(boolean hadRetiredStatus) {
        this.hadRetiredStatus = hadRetiredStatus;
    }

    public boolean isHadInvalidStatus() {
        return hadInvalidStatus;
    }

    public void setHadInvalidStatus(boolean hadInvalidStatus) {
        this.hadInvalidStatus = hadInvalidStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
