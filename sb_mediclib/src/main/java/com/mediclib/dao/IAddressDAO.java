package com.mediclib.dao;

import com.mediclib.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressDAO extends JpaRepository<Address, Integer> {
}
