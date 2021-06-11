package com.mediclib.dao;


import com.mediclib.model.MedSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedSpecialityDao extends JpaRepository<MedSpeciality, Integer> {
}
