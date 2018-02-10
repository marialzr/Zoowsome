package javasmmr.zoowsome.models.animals;

public class Colibri extends Bird {
    public Colibri(double maintenance, double danger){
        super(maintenance, danger);
        super.name="";
        super.nrOfLegs=2;
        super.avgFlightAltitude=20;
        super.migrates=false;
    }

    public Colibri(String name, int nrOflegs, int avgFlightAltitude, boolean migrates, double maintenance, double danger){
        super(maintenance, danger);
        super.name=name;
        super.nrOfLegs=nrOfLegs;
        super.avgFlightAltitude=avgFlightAltitude;
        super.migrates=migrates;
    }
}
