package com.afautos.main.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.user.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
