package com.mediclib.service;

import com.mediclib.dao.IClinicDao;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
    @Autowired
    private IClinicDao cliDao;

    public List<Clinic> findAll() {
        return this.cliDao.findAll();
    }
    public Clinic findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.cliDao.findById(id).orElseThrow(null);
    }
    public Clinic add(Clinic newClinic) {

        return this.cliDao.save(newClinic);
    }
    public void update(Clinic upClinic) {

        this.cliDao.save(upClinic);
    }
    public void deleteById(int id) {

        this.cliDao.deleteById(id);
    }
}
