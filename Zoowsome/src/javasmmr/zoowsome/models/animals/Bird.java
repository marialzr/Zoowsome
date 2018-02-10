package javasmmr.zoowsome.models.animals;

public class Bird extends Animal {
    protected boolean migrates;
    protected int avgFlightAltitude;

    public Bird(double maintenance, double danger){
        super(maintenance, danger);
    }

    public boolean isMigrates() {
        return migrates;
    }

    public int getAvgFlightAltitude() {
        return avgFlightAltitude;
    }

    public void setMigrates(boolean migrates) {
        this.migrates = migrates;
    }

    public void setAvgFlightAltitude(int avgFlightAltitude) {
        this.avgFlightAltitude = avgFlightAltitude;
    }
}
