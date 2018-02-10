package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.services.factories.constants.Constants;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Butterfly extends Insect {
    public Butterfly(double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=8;
        super.name="";
        super.canFly=true;
        super.isDangerous=false;
    }

    public Butterfly(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenance, double danger){
        super(maintenance, danger);
        super.nrOfLegs=nrOfLegs;
        super.name=name;
        super.canFly=canFly;
        super.isDangerous=isDangerous;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
        System.out.println("in encode in butterfly");
        super.encodeToXml(eventWriter);
        AnimalRepository.createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insects.Butterfly);
    }
}
