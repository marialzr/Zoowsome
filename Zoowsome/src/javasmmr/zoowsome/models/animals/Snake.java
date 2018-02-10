package javasmmr.zoowsome.models.animals;

public class Snake extends Reptile {
    public Snake(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.nrOfLegs=0;
        super.laysEggs=false;
    }

    public Snake(String name, int nrOfLegs, boolean laysEggs, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.laysEggs=laysEggs;
        super.nrOfLegs=nrOfLegs;
    }
}
