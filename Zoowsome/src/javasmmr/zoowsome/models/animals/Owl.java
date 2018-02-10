package javasmmr.zoowsome.models.animals;

public class Owl extends Bird {
    public Owl(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.avgFlightAltitude=5;
        super.migrates=false;
        super.nrOfLegs=2;
    }

    public Owl(String name, int avgFlightAltitude, int nrOfLegs, boolean migrates, double maintenance, double danger){
        super(maintenance, danger);
        super.avgFlightAltitude=avgFlightAltitude;
        super.name=name;
        super.migrates=migrates;
        super.nrOfLegs=nrOfLegs;
    }
}
