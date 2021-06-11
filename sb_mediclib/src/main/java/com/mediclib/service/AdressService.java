package com.mediclib.service;

import com.mediclib.dao.IAddressDAO;
import com.mediclib.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    @Autowired
    private IAddressDAO adrDAO;


    public List<Address> findAll() {

        return this.adrDAO.findAll();
    }

    public Address findById(int id) {

        return this.adrDAO.findById(id).orElseThrow(null);
    }
    public Address add(Address address) {
        return this.adrDAO.save(address);
    }
    public void update(Address address) {
        this.adrDAO.save(address);
    }
    public void deleteById(int id) {
        this.adrDAO.deleteById(id);
    }
}
