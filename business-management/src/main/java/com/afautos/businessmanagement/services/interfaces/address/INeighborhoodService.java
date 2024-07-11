package com.afautos.businessmanagement.services.interfaces.address;

import com.afautos.businessmanagement.error.NotFoundException;
import com.afautos.businessmanagement.persistence.entity.address.NeighborhoodEntity;

public interface INeighborhoodService {
    NeighborhoodEntity getNeighborhoodById(Integer id) throws NotFoundException;
}
