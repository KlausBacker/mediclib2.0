package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mediclib.projection.Views;

import javax.persistence.*;
import javax.swing.text.View;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Doctor")

public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_id")
    @JsonView(Views.Common.class)
    private int id;

    @Column(name = "doc_last_name", length = 100, nullable = false)
    @NotBlank
    @JsonView(Views.Doctor.class)
    private String firstName;

    @Column(name = "doc_first_name", length = 100, nullable = false)
    @NotBlank
    @JsonView(Views.Doctor.class)
    private String lastName;

    @Column(name = "doc_sector", length = 11, nullable = false)
    @NotNull
    @JsonView(Views.Doctor.class)
    private int sector;

    @ManyToMany
    @JoinTable(
            name = "Doctor_speciality",
            /*TABLE Doctor*/
            joinColumns = @JoinColumn(name = "docspe_doctor_id", referencedColumnName = "doc_id"),
            /*TABLE Med_speciality */
            inverseJoinColumns = @JoinColumn(name = "docspe_speciality_id", referencedColumnName = "Medspe_id")
    )
    @JsonView(Views.DoctorComplete.class)
    private List<MedSpeciality> specialityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public List<MedSpeciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<MedSpeciality> specialityList) {
        this.specialityList = specialityList;
    }
}
