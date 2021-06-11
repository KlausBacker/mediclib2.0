package com.mediclib.service;

import com.mediclib.dao.IMedConditionDao;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.MedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedConditionService {

    @Autowired
    private IMedConditionDao medConDao;

    public List<MedCondition> findAll() {

        return this.medConDao.findAll();
    }
    public MedCondition findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.medConDao.findById(id).orElseThrow(null);
    }
    public MedCondition add(MedCondition medCondition) {

       return this.medConDao.save(medCondition);
    }
    public void update(MedCondition medCondition) {

        this.medConDao.save(medCondition);
    }
    public void deleteById(int id) {

        this.medConDao.deleteById(id);
    }
}
