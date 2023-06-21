package org.covert.services;

import lombok.RequiredArgsConstructor;
import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.DistrictRepository;
import org.covert.repositories.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolutionsService {
    private final SolutionsRepository solutionsRepository;
    public List<Solutions> findAllSolutions() {
        return solutionsRepository.findAll();
    }
}
//
//    public List<Solutions> getSolutions(Long id){
//        Optional<Solutions> solution = solutionsRepository.findById(id);
//        if (!solution.isPresent()) { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "District not found");}
//        else {
//            return solution.get().get;
//
//}
