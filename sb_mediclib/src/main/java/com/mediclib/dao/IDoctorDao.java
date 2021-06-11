package com.mediclib.dao;


import com.mediclib.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorDao extends JpaRepository<Doctor, Integer> {
}
