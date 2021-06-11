package com.mediclib.service;

import com.mediclib.dao.IPatMedCondition;
import com.mediclib.exception.IdMustBePositiveException;
import com.mediclib.model.PatMedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatMedCondService {

    @Autowired
    private IPatMedCondition patMedConDao;

    public List<PatMedCondition> findAll() {

        return this.patMedConDao.findAll();
    }

    public PatMedCondition add(PatMedCondition newDisease) {

       return this.patMedConDao.save(newDisease);
    }
    public void update(PatMedCondition upDisease) {

        this.patMedConDao.save(upDisease);
    }
//    public void deleteById(int id) {
//        this.patMedConDao.deleteById(id);
//    }
}
