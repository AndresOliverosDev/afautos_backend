package com.afautos.businessmanagement.services.implementation.address;

import com.afautos.businessmanagement.error.ResourceNotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.AddressEntity;
import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;
import com.afautos.businessmanagement.persistence.entity.user.UserEntity;
import com.afautos.businessmanagement.persistence.repository.address.AddressRepository;
import com.afautos.businessmanagement.presentation.dto.address.request.AddressRequestDTO;
import com.afautos.businessmanagement.presentation.dto.address.response.AddressSummaryResponseDTO;
import com.afautos.businessmanagement.services.interfaces.address.IAddressService;
import com.afautos.businessmanagement.services.interfaces.address.INeighborhoodService;
import com.afautos.businessmanagement.services.interfaces.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService {

    // Dependency Injection

    private final AddressRepository addressRepository;
    private final IUserService userService;
    private final INeighborhoodService neighborhoodService;

    public AddressServiceImpl(AddressRepository addressRepository, IUserService userService, INeighborhoodService neighborhoodService) {
        this.addressRepository = addressRepository;
        this.userService = userService;
        this.neighborhoodService = neighborhoodService;
    }

    // Business Model Methods Read

    @Override
    public List<AddressSummaryResponseDTO> getAddressByUser(String userId) {
        try {
            List<AddressSummaryResponseDTO> addressSummaryResponseDTOS = addressRepository.getAddressByUser(userId);

            if (addressSummaryResponseDTOS.isEmpty()) {
                throw new ResourceNotFoundException("El usuario no tiene direcciones asociadas");
            }

            return addressSummaryResponseDTOS;
        } catch (ResourceNotFoundException ex) {
            return Collections.emptyList();
        }
    }

    @Override
    public ResponseEntity<String> createAddress(AddressRequestDTO addressRequestDTO) {
        try {
            // Find user
            UserEntity userCurrent = userService.getUserEntityById(addressRequestDTO.userId());

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
