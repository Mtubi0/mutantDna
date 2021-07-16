package ar.com.mutantdna.model;

import java.util.ArrayList;
import java.util.List;

public class DnaMatrix {
    
    private List<DnaSequence> sequences;

    public DnaMatrix() {
        sequences = new ArrayList<>();
    }

    public DnaMatrix(List<DnaSequence> sequences) {
        this.sequences = sequences;
    }

    public List<DnaSequence> getSequences() {
        return sequences;
    }

    public void setSequences(List<DnaSequence> sequences) {
        this.sequences = sequences;
    }

    public void addSequence(DnaSequence sequence) {
        sequences.add(sequence);
    }

    public List<DnaSequence> getDiagonalSequences() {

        Integer maxX = sequences.get(0).size();
        Integer maxY = sequences.size();
        List<DnaSequence> diagonalSequences = new ArrayList<>();

        for(var x = 0; x < maxX; x++) {

            var forwardDiagonalSequence = new DnaSequence();
            var backwardDiagonalSequence = new DnaSequence();
            Integer offset = 0;

            for(var y = 0; y < maxY; y++) {

                DnaBase dnaBase = sequences.get(y).getDnaBase(x + offset);             
                if(!dnaBase.equals(DnaBase.NullBase)) {
                    backwardDiagonalSequence.addDnaBase(dnaBase);
                }
                dnaBase = sequences.get(y).getDnaBase(x - offset);             
                if(!dnaBase.equals(DnaBase.NullBase)) {
                    forwardDiagonalSequence.addDnaBase(dnaBase);
                }
                offset++;
            }
            diagonalSequences.add(forwardDiagonalSequence);
            diagonalSequences.add(backwardDiagonalSequence);
        }
        for(var x = 1; x < maxX - 1; x++) {

            var forwardDiagonalSequence = new DnaSequence();
            var backwardDiagonalSequence = new DnaSequence();
            Integer offset = 0;

            for(var y = maxY - 1; y > 0; y--) {

                DnaBase dnaBase = sequences.get(y).getDnaBase(x + offset);             
                if(!dnaBase.equals(DnaBase.NullBase)) {
                    backwardDiagonalSequence.addDnaBase(dnaBase);
                }
                dnaBase = sequences.get(y).getDnaBase(x - offset);             
                if(!dnaBase.equals(DnaBase.NullBase)) {
                    forwardDiagonalSequence.addDnaBase(dnaBase);
                }
                offset++;
            }
            diagonalSequences.add(forwardDiagonalSequence);
            diagonalSequences.add(backwardDiagonalSequence);
        }
        return diagonalSequences;
    }

    public List<DnaSequence> getVerticalSequences() {

        List<DnaSequence> verticalSequences = new ArrayList<>();
        Integer maxX = sequences.get(0).size();
        Integer maxY = sequences.size();

        for(var x = 0; x < maxX; x++) {
            
            var verticalSequence = new DnaSequence();

            for(var y = 0; y < maxY; y++) {
                verticalSequence.addDnaBase(sequences.get(y).getDnaBase(x));
            }
            verticalSequences.add(verticalSequence);
        }
        return verticalSequences;
    }
}