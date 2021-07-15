package ar.com.mutantdna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mutantdna.model.DnaMatrix;
import ar.com.mutantdna.model.dto.DnaEvaluationRequest;
import ar.com.mutantdna.service.MutantService;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    MutantService service;

    @Autowired
    ConversionService converter;

    @PostMapping("/")
    public Boolean evaluate(@RequestBody DnaEvaluationRequest request) {
        return service.evaluate(converter.convert(request, DnaMatrix.class));
    }
}