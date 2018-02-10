package javasmmr.zoowsome.models.animals;

public class Medusa extends Aquatic {
    public Medusa(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.nrOfLegs=0;
        super.avgSwimDepth=30;
        super.waterType=Enum.BRINE;
    }

    public Medusa(String name, int nrOfLegs, int avgSwimDepth, Enum waterType, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.nrOfLegs=nrOfLegs;
        super.waterType=waterType;
        super.avgSwimDepth=avgSwimDepth;
    }
}
