package com.afautos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.afautos.main.models.EntryDetail;

@Repository
public interface EntryDetailRepository extends JpaRepository<EntryDetail, Integer>{
    
}
