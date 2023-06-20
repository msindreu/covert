package org.covert.services;

import org.covert.models.Solutions;
import org.covert.repositories.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SolutionsService {
    @Autowired
    SolutionsRepository solutionsRepository;
}
