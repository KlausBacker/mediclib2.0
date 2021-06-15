package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.projection.Views;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "med_condition")
public class MedCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "medco_id")
    @JsonView(Views.Common.class)
    private int id;
    @JsonView(Views.MedCond.class)
    @Column(name = "medco_name", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)

    private String name;

    @ManyToOne
    @JoinColumn(name = "medco_med_specialty_id")
    @JsonView(Views.MedCond.class)
    private MedSpeciality speciality;


//    @OneToMany(mappedBy = "id.disease")
//    private List<PatMedCondition> sickPatients;

    public int getId() {
        return id;
    }

    public void setId(int condId) {
        this.id = condId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MedSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedSpeciality speciality) {
        this.speciality = speciality;
    }

//    public List<PatMedCondition> getSickPatients() {
//        return sickPatients;
//    }
//
//    public void setSickPatients(List<PatMedCondition> sickPatients) {
//        this.sickPatients = sickPatients;
//    }
}
