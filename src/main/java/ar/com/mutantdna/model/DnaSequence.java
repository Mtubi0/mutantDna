package ar.com.mutantdna.model;

import java.util.ArrayList;
import java.util.List;

public class DnaSequence {

    List<DnaBase> dnaBases;

    public DnaSequence() {
        this.dnaBases = new ArrayList<>();
    }

    public DnaSequence(List<DnaBase> dnaBases) {
        this.dnaBases = dnaBases;
    }

    public Integer dnaBaseAmount() {
        return dnaBases.size();
    }

    public void addDnaBase(DnaBase dnaBase) {
        dnaBases.add(dnaBase);
    }

    public DnaBase getDnaBase(Integer index) {
        try {
            return dnaBases.get(index);
        } 
        catch(IndexOutOfBoundsException e) {
            return DnaBase.NullBase;
        }
    }

    public Integer size() {
        return dnaBases.size();
    }
}
