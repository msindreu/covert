package org.covert.controllers;

import lombok.RequiredArgsConstructor;
import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.services.DistrictService;
import org.covert.services.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
//@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequiredArgsConstructor
public class DistrictController {

    private final DistrictService districtService;
    private final SolutionsService solutionsService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public District getById(@PathVariable("id") Long id) {
        return districtService.getById(id);
    }
    @GetMapping("/solutions/{districtId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Solutions> getListOfSolutions(@PathVariable("districtId") Long id) {
        return districtService.getListOfSolutions(id);
    }
    @GetMapping("/nada")
    @ResponseStatus(HttpStatus.OK)
    public String test() {
        return "Hola Marina";
    }

    @GetMapping("/all")
    public List<District> getAllDistricts() {
        return districtService.findAllDistricts();
    }
}
