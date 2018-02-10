package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Colibri;
import javasmmr.zoowsome.models.animals.Owl;
import javasmmr.zoowsome.models.animals.Parrot;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class BirdsFactory extends SpeciesFactory {

    @Override
    public Animal getAnimal(String type) {
        if (Constants.Animals.Birds.Colibri.equals(type)){
            return new Colibri(7.8, 0.1);
        }
        else if (Constants.Animals.Birds.Owl.equals(type)){
            return new Owl(7, 0.4);
        }
        else if (Constants.Animals.Birds.Parrot.equals(type)){
            return new Parrot(8.0, 0.2);
        }
        return null;
    }
}
