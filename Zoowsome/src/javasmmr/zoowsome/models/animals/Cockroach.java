package javasmmr.zoowsome.models.animals;

public class Cockroach extends Insect {
    public Cockroach(double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=6;
        super.name="";
        super.canFly=true;
        super.isDangerous=false;
    }
    public Cockroach(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenance, double danger) {
        super(maintenance, danger);
        super.nrOfLegs=nrOfLegs;
        super.name=name;
        super.canFly=canFly;
        super.isDangerous=isDangerous;
    }

}
