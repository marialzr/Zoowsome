package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.services.factories.constants.Constants;

public class AnimalFactory {
    public SpeciesFactory getSpeciesFactory(String type){
        if (Constants.Species.Mammals.equals(type)){
            return new MammalFactory();
        }
        else if (Constants.Species.Aquatics.equals(type)){
            return new AquaticsFactory();
        }
        else if (Constants.Species.Birds.equals(type)){
            return new BirdsFactory();
        }
        else if (Constants.Species.Reptiles.equals(type)){
            return new ReptilesFactory();
        }
        else if (Constants.Species.Insects.equals(type)){
            return new InsectsFactory();
        }
        return null;
    }
}
