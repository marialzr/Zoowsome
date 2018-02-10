package javasmmr.zoowsome.models.animals;

public class Reptile extends Animal {
    protected boolean laysEggs;

    public Reptile(double maintenance, double danger){
        super(maintenance, danger);
    }
    public boolean getLaysEggs() {
        return laysEggs;
    }

    public void setLaysEggs(boolean laysEggs) {
        this.laysEggs = laysEggs;
    }
}
