package javasmmr.zoowsome.models.animals;

public abstract class Mammal extends Animal{
    protected float normalBodyTemp;
    protected float percBodyHair;
    public Mammal(double maintenance, double danger){
        super(maintenance,danger);
    }

    public float getNormalBodyTemp() {
        return normalBodyTemp;
    }

    public float getPercBodyHair() {
        return percBodyHair;
    }

    public void setNormalBodyTemp(float normalBodyTemp) {
        this.normalBodyTemp = normalBodyTemp;
    }

    public void setPercBodyHair(float percBodyHair) {
        this.percBodyHair = percBodyHair;
    }
}
