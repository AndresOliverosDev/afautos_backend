package com.afautos.businessmanagement.services.implementation.address;

import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.address.AddressRepository;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import com.afautos.businessmanagement.services.interfaces.address.INeighborhoodService;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements IAddressService {

    // Dependency Injection

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private INeighborhoodService neighborhoodService;

    // Business Model Methods

    @Override
    public ResponseEntity<String> createAddress(AddressRequestDTO addressRequestDTO) {
        try {
            // Find user
            UserEntity userCurrent = userService.getUserById(addressRequestDTO.userId());

            // Find neighborhood
            NeighborhoodEntity neighborhood = neighborhoodService.getNeighborhoodById(addressRequestDTO.neighborhoodId());

            // create address entity
            AddressEntity addressCurrent = new AddressEntity();
            addressCurrent.setNeighborhood(neighborhood);
            addressCurrent.setRef(addressRequestDTO.ref());
            addressCurrent.setUser(userCurrent);

            addressRepository.save(addressCurrent);

            return ResponseEntity.ok("La dirección se creó correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la dirección: " + e.getMessage());
        }
    }

}
