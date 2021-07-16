package ar.com.mutantdna.converter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;

import ar.com.mutantdna.model.dna.DnaBase;
import ar.com.mutantdna.model.dna.DnaMatrix;
import ar.com.mutantdna.model.dna.DnaSequence;
import ar.com.mutantdna.model.dto.DnaEvaluationRequest;

public class DnaEvaluationRequestToDnaMatrixConverter implements Converter<DnaEvaluationRequest, DnaMatrix> {

    private static final Map<Character, DnaBase> mapper = new HashMap<>();
    static {
        mapper.put('A', DnaBase.Adenine);
        mapper.put('C', DnaBase.Cytosine);
        mapper.put('G', DnaBase.Guanine);
        mapper.put('T', DnaBase.Thymine);
    }

    @Override
    public DnaMatrix convert(DnaEvaluationRequest request) {

        List<String> sequences = Arrays.asList(request.getDna());
        DnaMatrix matrix = new DnaMatrix();

        for(String sequence : sequences) {
            var dnaSequence = new DnaSequence();

            for(Character baseCharacter : sequence.toCharArray()) {
                dnaSequence.addDnaBase(mapper.get(baseCharacter));
            }
            matrix.addSequence(dnaSequence);
        }
        return matrix;
    }
}
