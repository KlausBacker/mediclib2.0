package com.mediclib.dao;


import com.mediclib.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClinicDao extends JpaRepository<Clinic, Integer> {
}
