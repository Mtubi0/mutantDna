package ar.com.mutantdna.converter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.com.mutantdna.model.DnaMatrix;
import ar.com.mutantdna.model.dto.DnaEvaluationRequest;
import ar.com.mutantdna.service.MutantService;

public class DnaEvaluationRequestToDnaMatrixConverterTest {

    MutantService service = new MutantService();

    @Test
    public void convertShouldReturnMutant() {

        DnaEvaluationRequestToDnaMatrixConverter converter = new DnaEvaluationRequestToDnaMatrixConverter();

        DnaEvaluationRequest request = new DnaEvaluationRequest();
        request.setDna(new String[] {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"});
        
        assertFalse(service.evaluate(converter.convert(request)));
    }

    @Test
    public void convertShouldNotReturnMutant() {

        DnaEvaluationRequestToDnaMatrixConverter converter = new DnaEvaluationRequestToDnaMatrixConverter();

        DnaEvaluationRequest request = new DnaEvaluationRequest();
        request.setDna(new String[] {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"});

        assertTrue(service.evaluate(converter.convert(request)));
    }
}
