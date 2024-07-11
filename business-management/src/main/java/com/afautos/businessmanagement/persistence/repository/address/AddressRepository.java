package com.afautos.businessmanagement.persistence.repository.address;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT new com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO" +
            "(a.id, a.ref, a.neighborhood.name, a.neighborhood.city.name) " +
            "FROM AddressEntity a " +
            "WHERE a.user.id = :userId")
    List<AddressSummaryResponseDTO> getAddressByUser(@Param("userId") String userId);
}
