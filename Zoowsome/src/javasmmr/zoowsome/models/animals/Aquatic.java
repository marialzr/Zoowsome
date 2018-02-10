package javasmmr.zoowsome.models.animals;

public class Aquatic extends Animal {
    protected int avgSwimDepth;
    protected Enum waterType;

    public Aquatic(double maintenance, double danger){
        super(maintenance, danger);
    }

    public int getAvgSwimDepth() {
        return avgSwimDepth;
    }

    public Enum getWaterType() {
        return waterType;
    }

    public void setAvgSwimDepth(int avgSwimDepth) {
        this.avgSwimDepth = avgSwimDepth;
    }

    public void setWaterType(Enum waterType) {
        this.waterType = waterType;
    }
}
