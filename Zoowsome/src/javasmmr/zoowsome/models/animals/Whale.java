package javasmmr.zoowsome.models.animals;

public class Whale extends Aquatic {
    public Whale(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.nrOfLegs=0;
        super.avgSwimDepth=100;
        super.waterType=Enum.BRINE;
    }

    public Whale(String name, int nrOfLegs, int avgSwimDepth, Enum waterType, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.nrOfLegs=nrOfLegs;
        super.avgSwimDepth=avgSwimDepth;
        super.waterType=waterType;
    }
}
