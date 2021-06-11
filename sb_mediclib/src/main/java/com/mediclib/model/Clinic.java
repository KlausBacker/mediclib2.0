package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.projection.Views;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cli_id")
    @JsonView(Views.Common.class)
    private int id;

    @Column(name = "cli_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int cliID) {
        this.id = cliID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address cliAddress) {
        this.address = cliAddress;
    }

    @Column(name = "cli_phone_number", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String tel;


    @OneToOne
    @JoinColumn(name = "cli_address_id")
    private Address address;
}
