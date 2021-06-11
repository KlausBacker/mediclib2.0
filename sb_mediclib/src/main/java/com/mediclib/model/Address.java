package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.projection.Views;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adr_id")
    @JsonView(Views.Common.class)
    private int id;

    @Column(name = "adr_street", length = 200, nullable = false)
    @NotBlank
    @Size(max = 200)
    @JsonView(Views.Address.class)
//    @JsonView(Views.PatientExtended.class)
    private String street;

    @Column(name = "adr_street_number", length = 11, nullable = false)
    @NotBlank
    @Size(max = 11)
    @JsonView(Views.Address.class)
//    @JsonView(Views.PatientExtended.class)
    private String streetNumber;

    @Column(name = "adr_postcode", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    @JsonView(Views.Address.class)
//    @JsonView(Views.PatientExtended.class)
    private String postcode;

    @Column(name = "adr_city", length = 150, nullable = false)
//    @JsonView(Views.PatientExtended.class)
    @JsonView(Views.Address.class)
    private String city;

    @Column(name = "adr_line_1", length = 300)
    @JsonView(Views.AddressComplete.class)
    private String line1;

    @Column(name = "adr_line_2", length = 300)
    @JsonView(Views.AddressComplete.class)
    private String line2;

    @Column(name = "adr_country", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    @JsonView(Views.Address.class)
    private String country = "France";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String crountry) {
        this.country = crountry;
    }
}
