package javasmmr.zoowsome.models.animals;

import java.util.ArrayList;

public class Aligator extends Reptile {
    public Aligator(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.nrOfLegs=0;
        super.laysEggs=true;

    }

    public Aligator(int nrOfLegs, String name, double maintenance, double danger, boolean takenCareOf, boolean laysEggs){
        super(maintenance, danger);  //first element=maintenance, second=danger
        super.name=name;
        super.laysEggs=laysEggs;
        super.nrOfLegs=nrOfLegs;
        super.takenCareOf=takenCareOf;
        super.laysEggs=laysEggs;
    }
}
