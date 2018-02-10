package javasmmr.zoowsome.models.animals;

public class Rac extends Aquatic {
    public Rac(double maintenance, double danger) {
        super(maintenance, danger);
        super.name = "";
        super.nrOfLegs = 0;
        super.avgSwimDepth = 50;
        super.waterType = Enum.BRINE;
    }
    public Rac(String name, int nrOfLegs, int avgSwimDepth, Enum waterType, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.nrOfLegs=nrOfLegs;
        super.avgSwimDepth=avgSwimDepth;
        super.waterType=waterType;
    }
}
