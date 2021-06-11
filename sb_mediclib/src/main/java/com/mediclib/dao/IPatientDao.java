package com.mediclib.dao;


import com.mediclib.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientDao extends JpaRepository<Patient, Integer> {
}
