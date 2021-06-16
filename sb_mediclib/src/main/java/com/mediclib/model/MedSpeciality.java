package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mediclib.projection.Views;

import javax.persistence.*;
import javax.print.Doc;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Med_speciality")
public class MedSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Medspe_id")
    @JsonView(Views.Common.class)
    private int id;

    @Column(name = "Medspe_name", length = 100, nullable = false)
    @NotBlank
    @JsonView(Views.MedSpe.class)
    private String name;

    @ManyToMany(mappedBy = "specialityList")
    @JsonView(Views.MedSpeComplete.class)
    private List<Doctor> doctorList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
