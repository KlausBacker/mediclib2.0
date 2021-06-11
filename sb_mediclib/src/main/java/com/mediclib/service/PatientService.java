package com.mediclib.service;

import com.mediclib.dao.IPatientDao;
import com.mediclib.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

   @Autowired
   private IPatientDao dao;

    public List<Patient> findAll() {

        return this.dao.findAll();
    }


    public Patient findById(int id) {

        return this.dao.findById(id).orElseThrow(null);
    }

    public Patient addPatient (Patient addedPatient) {

      return this.dao.save(addedPatient);
    }
    public void updatePatient (Patient updatedPatient) {

        this.dao.save(updatedPatient);
    }

    public void deleteById(int id) {

       this.dao.deleteById(id);
    }

}
