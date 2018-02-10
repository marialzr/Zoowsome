package javasmmr.zoowsome.models.animals;

public class Monkey extends Mammal{
    public Monkey(double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=4;
        super.name="";

        super.normalBodyTemp=0;
        super.percBodyHair=0;
    }

    public Monkey(int nrOfLegs, String name, float normalBodyTemp, float percBodyHair, double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=nrOfLegs;
        super.name=name;

        super.normalBodyTemp=normalBodyTemp;
        super.percBodyHair=percBodyHair;

    }
}
