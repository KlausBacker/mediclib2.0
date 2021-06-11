package com.mediclib.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mediclib.projection.Views;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name= "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "app_id")
    @JsonView(Views.Common.class)
    private int id;

    @OneToOne
    @JoinColumn(name = "app_doctor_id")
    @JsonView(Views.Appointment.class)
    private Doctor doctor;

    public int getId() {
        return id;
    }

    public void setId(int appId) {
        this.id = appId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime appDate) {
        this.date = appDate;
    }

    @OneToOne
    @JoinColumn(name = "app_patient_id")
    @JsonView(Views.Appointment.class)
    private Patient patient;

    @Column(name = "app_date", nullable = false)
    @JsonView(Views.Appointment.class)
    private LocalDateTime date;
}
