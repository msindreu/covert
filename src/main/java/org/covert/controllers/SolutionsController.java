package org.covert.controllers;

import lombok.RequiredArgsConstructor;
import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.SolutionsRepository;
import org.covert.services.SolutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solutions")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequiredArgsConstructor
public class SolutionsController {

    private final SolutionsService solutionsService;

    @GetMapping
    public List<Solutions> getAllSolutions() {
        var what = solutionsService.findAllSolutions();
        return what;
    }

    @GetMapping("/{id}")
    public List<Solutions> getSolutionsById(@PathVariable("districtId") Long id) {
        return solutionsService.findAllSolutions();
    }
}
