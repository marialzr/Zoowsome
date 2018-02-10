package javasmmr.zoowsome.models.animals;

public class Spider extends Insect {
    public Spider(double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=8;
        super.name="";
        super.canFly=true;
        super.isDangerous=false;
    }

    public Spider(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=nrOfLegs;
        super.name=name;
        super.canFly=canFly;
        super.isDangerous=isDangerous;
    }
}
