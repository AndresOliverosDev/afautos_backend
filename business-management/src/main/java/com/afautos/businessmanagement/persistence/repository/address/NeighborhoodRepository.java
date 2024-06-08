package com.afautos.businessmanagement.persistence.repository.address;

import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NeighborhoodRepository extends JpaRepository<NeighborhoodEntity, Integer> {
}
