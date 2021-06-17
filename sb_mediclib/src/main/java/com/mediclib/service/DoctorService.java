package com.mediclib.service;


import com.mediclib.dao.IDoctorDao;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.Doctor;
import com.mediclib.model.MedSpeciality;
import com.mediclib.projection.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private IDoctorDao dao;

    public List<Doctor> findAll() {

        return this.dao.findAll();
    }

    public List<Doctor> findAllBySpe(int id) {

        List<Doctor> docThatHaveThisSpe = new ArrayList<>();
        MedSpecialityService medSpeSrv = new MedSpecialityService();
        MedSpeciality medSpe = medSpeSrv.findById(id);

        docThatHaveThisSpe.add((Doctor) medSpe.getDoctorList());
        return docThatHaveThisSpe;
    }

    public Doctor findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.dao.findById(id).orElseThrow(null);
    }

    public Doctor add(Doctor doctor) {

        return this.dao.save(doctor);
    }

    public void update(Doctor doctor) {

        this.dao.save(doctor);
    }

    public void deleteById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }
        this.dao.deleteById(id);
    }

}
