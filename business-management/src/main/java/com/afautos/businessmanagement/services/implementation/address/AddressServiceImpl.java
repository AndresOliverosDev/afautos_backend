package com.afautos.businessmanagement.services.implementation.address;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.address.AddressRepository;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import com.afautos.businessmanagement.services.interfaces.address.INeighborhoodService;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AddressEntity createAddress(AddressRequestDTO addressRequestDTO) {
        try {
            // User
            UserEntity userCurrent = userService.getUserById(addressRequestDTO.userId());

            // Neighborhood
            NeighborhoodEntity neighborhood = neighborhoodService.getNeighborhoodById(addressRequestDTO.neighborhoodId());

            AddressEntity addressCurrent = new AddressEntity();
            addressCurrent.setNeighborhood(neighborhood);
            addressCurrent.setRef(addressRequestDTO.ref());
            addressCurrent.setUser(userCurrent);

            return addressCurrent;
        } catch (LocalNotFoundException e) {
            throw new RuntimeException("Error al crear la dirección", e);
        }
    }

}
