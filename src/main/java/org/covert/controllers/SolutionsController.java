package org.covert.controllers;

import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map/district/solutions")
@CrossOrigin(origins = "http://localhost:3000", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class SolutionsController {
    @Autowired
    SolutionsRepository solutionsRepository;

}
