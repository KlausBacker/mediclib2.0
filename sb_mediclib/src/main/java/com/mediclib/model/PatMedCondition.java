package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.projection.Views;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patient_med_condition")
public class PatMedCondition {

    @EmbeddedId
    @JsonView(Views.PatientmedCondtion.class)
    private PatMedCondID id;

    @Column(name = "patcon_detection_date", nullable = false)
    @JsonView(Views.PatientmedCondtion.class)
    private LocalDate detectionDate;

    public PatMedCondID getId() {
        return id;
    }

    public void setId(PatMedCondID id) {
        this.id = id;
    }

    public LocalDate getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(LocalDate detectionDate) {
        this.detectionDate = detectionDate;
    }
}
