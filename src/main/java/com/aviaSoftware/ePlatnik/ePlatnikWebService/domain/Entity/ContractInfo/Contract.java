package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.ContractInfo;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Contract.Id", query = "select c from Contract as c where c.id=:contractId"),
        @NamedQuery(name = "Contract.All", query = "select c from Contract as c"),
        @NamedQuery (name="Contract.useIdToFindBonus" ,query= "select c.bonus from Contract as c where c.id=:contractId")
})
@Table(name = "CONTRACT")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeContract;
    private String startTimeContract;
    private String endTimeContract;
    private int freeDay;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRACT_PROPERTIES_ID", nullable = false)
    private ContractProperties contractProperties = new ContractProperties();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BONUS_ID", nullable = false)
    private Bonus bonus = new Bonus();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner_raport")
    private List<RaportOfWork> raports = new ArrayList<RaportOfWork>();

    private String jobPosition;

    public List<RaportOfWork> getRaports() {
        return raports;
    }

    public void setRaports(ArrayList<RaportOfWork> raports) {
        this.raports = raports;
    }

    public String getTypeContract() {
        return typeContract;
    }

    public void setTypeContract(String typeContract) {
        this.typeContract = typeContract;
    }

    public String getStartTimeContract() {
        return startTimeContract;
    }

    public void setStartTimeContract(String startTimeContract) {
        this.startTimeContract = startTimeContract;
    }

    public String getEndTimeContract() {
        return endTimeContract;
    }

    public void setEndTimeContract(String endTimeContract) {
        this.endTimeContract = endTimeContract;
    }

    public int getFreeDay() {
        return freeDay;
    }

    public void setFreeDay(int freeDay) {
        this.freeDay = freeDay;
    }

    public ContractProperties getContractProperties() {
        return contractProperties;
    }

    public void setContractProperties(ContractProperties contractProperties) {
        this.contractProperties = contractProperties;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRaports(List<RaportOfWork> raports) {
        this.raports = raports;
    }

    public void addRaportOfWork (RaportOfWork raportOfWork){
        raports.add(raportOfWork);
        if (raportOfWork.getOwner_raport() != this) {
            raportOfWork.setOwner_raport(this);
        }
    }
}
