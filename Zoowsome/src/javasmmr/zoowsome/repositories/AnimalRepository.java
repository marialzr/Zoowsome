package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Butterfly;
import javasmmr.zoowsome.services.factories.constants.Constants;
// import javasmmr.zoowsome.services.factories.constants.Constants;


public class AnimalRepository extends EntityRepository<Animal>{
    public AnimalRepository(){
        super("Animals.xml", Constants.XML_TAGS.ANIMAL);
    }

    @Override
    public Animal getEntityFromXmlElement(org.w3c.dom.Element element){
        String discriminant=element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
        switch(discriminant){
            case Constants.Animals.Insects.Butterfly:
                double maintenanceCost=Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent());
                double dangerPerc=Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent());
                Animal butterfly=new Butterfly(maintenanceCost,dangerPerc);
                butterfly.decodeFromXml(element);
                return butterfly;
            default: //you must also check for all types of animals from all subclasses of animal
                break;
        }
        return null;
    }
}
