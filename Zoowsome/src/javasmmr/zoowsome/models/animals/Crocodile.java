package javasmmr.zoowsome.models.animals;

public class Crocodile extends Reptile {
    public Crocodile(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.laysEggs=false;
        super.nrOfLegs=0;
    }

    public Crocodile(String name, int nrOfLegs, boolean laysEggs, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.laysEggs=laysEggs;
        super.nrOfLegs=nrOfLegs;
    }
}
