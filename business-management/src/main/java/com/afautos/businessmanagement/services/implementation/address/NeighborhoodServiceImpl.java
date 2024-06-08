package com.afautos.businessmanagement.services.implementation.address;

import com.afautos.businessmanagement.error.LocalNotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;
import com.afautos.businessmanagement.persistence.repository.address.NeighborhoodRepository;
import com.afautos.businessmanagement.services.interfaces.address.INeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighborhoodServiceImpl implements INeighborhoodService {

    // Dependency Injection
    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    // Business Model Methods
    @Override
    public NeighborhoodEntity getNeighborhoodById(Integer id) throws LocalNotFoundException {
        return neighborhoodRepository.findById(id).orElseThrow(() ->
                new LocalNotFoundException("Barrio con el id " + id + " no existe")
        );
    }
}
