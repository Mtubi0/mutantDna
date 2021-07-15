package ar.com.mutantdna.model.dto;

public class DnaEvaluationRequest {

    private String[] dna;

    public DnaEvaluationRequest() {
        dna = new String[0];
    }
    public String[] getDna() {
        return dna;
    }
    public void setDna(String[] dna) {
        this.dna = dna;
    }
}
