package com.mediclib.service;


import com.mediclib.dao.IAppointmentDao;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private IAppointmentDao appDao;

    public List<Appointment> findAll() {

        return this.appDao.findAll();
    }
    public Appointment findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.appDao.findById(id).orElseThrow(null);
    }
    public Appointment add(Appointment appointment) {

      return this.appDao.save(appointment);
    }
    public void update(Appointment appointment) {

        this.appDao.save(appointment);
    }
    public void deleteById(int id) {

        this.appDao.deleteById(id);
    }
}
