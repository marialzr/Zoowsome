package javasmmr.zoowsome.models.animals;

public class Parrot extends Bird {
    public Parrot(double maintenance, double danger){
        super(maintenance, danger);
        super.avgFlightAltitude=5;
        super.migrates=false;
        super.nrOfLegs=2;
        super.name="";
    }

    public Parrot(String name, int avgFlightAltitude, int nrOfLegs, boolean migrates, double maintenance, double danger){
        super(maintenance, danger);
        super.avgFlightAltitude=avgFlightAltitude;
        super.migrates=migrates;
        super.name=name;
        super.nrOfLegs=nrOfLegs;
    }
}
