package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Entity.PersonInfo;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "Address.Id", query = "select a from Address as a where a.id=:personId ")
})
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private Long id;
    private String postalCode;
    private String City;
    private String Country;
    private int flatNumber;
    private String street;
    @OneToOne(mappedBy = "adress", fetch = FetchType.LAZY, optional = true)
    private Person person;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return City;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


}
