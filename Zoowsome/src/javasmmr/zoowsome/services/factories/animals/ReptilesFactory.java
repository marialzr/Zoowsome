package javasmmr.zoowsome.services.factories.animals;

import javasmmr.zoowsome.models.animals.Aligator;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Crocodile;
import javasmmr.zoowsome.models.animals.Snake;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class ReptilesFactory extends SpeciesFactory {
    @Override
    public Animal getAnimal(String type){
        if (Constants.Animals.Reptiles.Aligator.equals(type)){
            return new Aligator(2.0, 0.9);
        }
        else if (Constants.Animals.Reptiles.Crocodile.equals(type)){
            return new Crocodile(3.0, 0.9);
        }
        else if (Constants.Animals.Reptiles.Snake.equals(type)){
            return new Snake(1.0, 1);
        }
        else {
        }
        return null;
    }
}
