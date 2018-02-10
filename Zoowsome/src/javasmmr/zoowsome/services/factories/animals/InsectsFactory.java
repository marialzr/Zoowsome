package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Butterfly;
import javasmmr.zoowsome.models.animals.Cockroach;
import javasmmr.zoowsome.models.animals.Spider;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class InsectsFactory extends SpeciesFactory {
    public Animal getAnimal(String type){
        if (Constants.Animals.Insects.Butterfly.equals(type)){
            return new Butterfly(4, 0.0);
        }
        else if (Constants.Animals.Insects.Cockroach.equals(type)){
            return new Cockroach(4, 0.1);
        }
        else if (Constants.Animals.Insects.Spider.equals(type)){
            return new Spider(0, 0.5);
        }
        return null;
    }
}
