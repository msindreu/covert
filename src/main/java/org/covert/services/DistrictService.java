package org.covert.services;

import lombok.RequiredArgsConstructor;
import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DistrictService {

    private final DistrictRepository districtRepository;

    public District getById(Long id){
        Optional<District> district = districtRepository.findById(id);
        if (district.isPresent()){ return district.get();}
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public double getLevelVegetation(Long id){
        Optional<District> district = districtRepository.findById(id);
        if (district.isPresent()) { return district.get().getLevelVegetation();}
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<Solutions> getListOfSolutions(Long id) {
        Optional<District> district = districtRepository.findById(id);
        if (!district.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        return district.get().getSolutions();
    }

    public List<District> findAllDistricts() {
        return districtRepository.findAll();
    }
}
