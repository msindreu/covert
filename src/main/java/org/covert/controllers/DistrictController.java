package org.covert.controllers;

import org.covert.models.District;
import org.covert.services.DistrictService;
import org.covert.services.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map/district")
public class DistrictController {
    @Autowired
    DistrictService districtService;
    @Autowired
    SolutionsService solutionsService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getById(@PathVariable("id") Long id){
        return "hello";
        //return districtService.getById(id);
    }
}
