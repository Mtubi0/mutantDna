package ar.com.mutantdna.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.mutantdna.model.DnaBase;
import ar.com.mutantdna.model.DnaMatrix;
import ar.com.mutantdna.model.DnaSequence;

@Service
public class MutantService {

    private static Integer matchNumber = 4;

    public Boolean evaluate(DnaMatrix dnaMatrix) {

        boolean evaluating = true;
        Integer matches = 0;
        List<DnaSequence> sequences = dnaMatrix.getVerticalSequences();
        sequences.addAll(dnaMatrix.getDiagonalSequences());
        
        Iterator<DnaSequence> it = sequences.iterator();

        while(evaluating || it.hasNext()) {

            DnaSequence dnaSequence = it.next();
            matches += countRepeatedDnaBase(dnaSequence, 4);

            if(matches >= matchNumber) {
                evaluating = false;
            }
        }
        return matches >= matchNumber;
    }

    private Integer countRepeatedDnaBase(DnaSequence sequence, Integer times) {

        Integer timesRepeated = 0;
        Integer totalRepeated = 0;
        DnaBase actualComparison = DnaBase.NullBase;

        for(var i = 0; i < sequence.size(); i++) {

            DnaBase dnaBase = sequence.getDnaBase(i);

            if(dnaBase.equals(actualComparison)) {
                timesRepeated++;
            }
            else {
                actualComparison = dnaBase;
            }

            if(timesRepeated >= times) {
                totalRepeated++;
            }
        }
        return totalRepeated;
    }
}