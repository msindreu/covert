package org.covert.controllers;

import org.covert.models.District;
import org.covert.models.Solutions;
import org.covert.repositories.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/map/district/solutions")
public class SolutionsController {
    @Autowired
    SolutionsRepository solutionsRepository;

}
