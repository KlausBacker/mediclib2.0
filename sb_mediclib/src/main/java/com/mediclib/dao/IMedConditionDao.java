package com.mediclib.dao;


import com.mediclib.model.MedCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedConditionDao extends JpaRepository<MedCondition, Integer> {
}
