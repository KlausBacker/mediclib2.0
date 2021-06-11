package com.mediclib.service;

import com.mediclib.dao.IMedSpecialityDao;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.MedSpeciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedSpecialityService {

    @Autowired
    private IMedSpecialityDao dao;

    public List<MedSpeciality> findAll() {

        return this.dao.findAll();
    }


    public MedSpeciality findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.dao.findById(id).orElseThrow(null);
    }
    public void add(MedSpeciality medspe) {

        this.dao.save(medspe);
    }

    public void update(MedSpeciality medspe) {

        this.dao.save(medspe);
    }
    public boolean delete(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }
        this.dao.deleteById(id);
        return false;
    }

}
