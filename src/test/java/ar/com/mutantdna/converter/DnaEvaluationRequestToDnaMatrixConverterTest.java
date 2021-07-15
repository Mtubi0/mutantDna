package ar.com.mutantdna.converter;

import org.junit.jupiter.api.Test;

import ar.com.mutantdna.model.dto.DnaEvaluationRequest;

public class DnaEvaluationRequestToDnaMatrixConverterTest {

    @Test
    public void convertShouldReturnConvertedMatrix() {

        DnaEvaluationRequestToDnaMatrixConverter converter = new DnaEvaluationRequestToDnaMatrixConverter();

        DnaEvaluationRequest request = new DnaEvaluationRequest();
        request.setDna(new String[] {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"});

        converter.convert(request);
    }
}
