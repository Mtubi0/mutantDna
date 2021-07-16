package ar.com.mutantdna.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.com.mutantdna.model.dna.DnaBase;
import ar.com.mutantdna.model.dna.DnaMatrix;
import ar.com.mutantdna.model.dna.DnaSequence;

@Service
public class MutantService {

    private static Integer matchNumber = 3;

    public Boolean evaluate(DnaMatrix dnaMatrix) {

        boolean evaluating = true;
        Integer matches = 0;
        List<DnaSequence> sequences = dnaMatrix.getSequences();
        sequences.addAll(dnaMatrix.getVerticalSequences());
        sequences.addAll(dnaMatrix.getDiagonalSequences());
        
        Iterator<DnaSequence> it = sequences.iterator();

        while(evaluating && it.hasNext()) {

            DnaSequence dnaSequence = it.next();
            matches += countRepeatedDnaBase(dnaSequence, matchNumber);

            if(matches >= matchNumber) {
                evaluating = false;
            }
        }
        return matches >= matchNumber;
    }

    private Integer countRepeatedDnaBase(DnaSequence sequence, Integer times) {

        Integer timesRepeated = 1;
        Integer totalRepeated = 0;
        DnaBase actualComparison = DnaBase.NullBase;

        for(var i = 0; i < sequence.size(); i++) {

            DnaBase dnaBase = sequence.getDnaBase(i);

            if(dnaBase.equals(actualComparison)) {
                timesRepeated++;
            }
            else {
                actualComparison = dnaBase;
                timesRepeated = 1;
            }

            if(timesRepeated >= times && !actualComparison.equals(DnaBase.NullBase)) {
                totalRepeated++;
            }
        }
        return totalRepeated;
    }
}
