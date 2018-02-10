package javasmmr.zoowsome.models.animals;

public class Cow extends Mammal {
    public Cow(double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=4;
        super.name="";

        super.normalBodyTemp=0;
        super.percBodyHair=0;

        //super.maintenanceCost=maintenance;
    }

    public Cow(int nrOfLegs, String name, float normalBodyTemp, float percBodyHair, double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=nrOfLegs;
        super.name=name;

        super.normalBodyTemp=normalBodyTemp;
        super.percBodyHair=percBodyHair;
        //super.maintenanceCost=maintenance;
    }
}
