package javasmmr.zoowsome.services.factories.animals;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Cow;
import javasmmr.zoowsome.models.animals.Monkey;
import javasmmr.zoowsome.models.animals.Tiger;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class MammalFactory extends SpeciesFactory {
    @Override
    public Animal getAnimal(String type){
        if (Constants.Animals.Mammals.Cow.equals(type)){
            return new Cow(0.2, 0.3);
        } else if (Constants.Animals.Mammals.Monkey.equals(type)){
            return new Monkey(8.0, 0.1);
        } else if (Constants.Animals.Mammals.Tiger.equals(type)){
            return new Tiger(7.1, 0.9);
        } else {
            //
        }
        return null;
    }
}
