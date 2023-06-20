package org.covert.controllers;

import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.services.DistrictService;
import org.covert.services.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @Autowired
    SolutionsService solutionsService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public District getById(@PathVariable("id") Long id) {
        return districtService.getById(id);
    }

    @GetMapping("/solutions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Solutions> getListOfSolutions(@PathVariable("id") Long id) {
        return districtService.getListOfSolutions(id);
    }
}
