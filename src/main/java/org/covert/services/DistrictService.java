package org.covert.services;

import org.covert.models.District;
import org.covert.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public District getById(Long id){
        Optional<District> district= districtRepository.findById(id);
        if (district.isPresent()) { return district.get();}
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
