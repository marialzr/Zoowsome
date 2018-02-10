package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Medusa;
import javasmmr.zoowsome.models.animals.Rac;
import javasmmr.zoowsome.models.animals.Whale;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class AquaticsFactory extends SpeciesFactory {
    public Animal getAnimal(String type){
        if (Constants.Animals.Aquatics.Medusa.equals(type)){
            return new Medusa(6.0, 0.3);
        }
        else if (Constants.Animals.Aquatics.Rac.equals(type)){
            return new Rac(3.0, 0.7);
        }
        else if (Constants.Animals.Aquatics.Whale.equals(type)){
            return new Whale(6.5, 0.5);
        }
        return null;
    }
}
