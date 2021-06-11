package com.mediclib.dao;

import com.mediclib.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentDao extends JpaRepository<Appointment, Integer> {
}
