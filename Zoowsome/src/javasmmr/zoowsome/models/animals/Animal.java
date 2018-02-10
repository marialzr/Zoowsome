package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.models.interfaces.Killer;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javax.xml.bind.Element;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import javasmmr.zoowsome.repositories.AnimalRepository;


public abstract class Animal implements Killer, XML_Parsable {
    protected int nrOfLegs;
    protected String name;
    protected final double maintenanceCost;
    protected final double dangerPerc;
    protected boolean takenCareOf=false;

    public Animal(double maintenance, double danger){
         maintenanceCost=maintenance;
         dangerPerc=danger;
    }

    public int getNrOfLegs() {
        return nrOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setNrOfLegs(int nrOfLegs) {
        this.nrOfLegs = nrOfLegs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaintenanceCost(){return this.maintenanceCost;}

    public double getDangerPerc(){return this.dangerPerc;}

    public boolean getTakenCareOf(){return this.takenCareOf;}

    public void setTakenCareOf(boolean takenCareOf){this.takenCareOf=takenCareOf;}


    @Override
    public boolean kill(){
        double nr= Math.random()*1;
        if (nr<this.dangerPerc){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public double getPredisposition(){
        return 0;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException{
        System.out.println("in animal");
        AnimalRepository.createNode(eventWriter, "nrOfLegs", String.valueOf(nrOfLegs));
        AnimalRepository.createNode(eventWriter, "name", name);
        AnimalRepository.createNode(eventWriter, "maintenanceCost", String.valueOf(maintenanceCost));
        AnimalRepository.createNode(eventWriter, "dangerPerc", String.valueOf(dangerPerc));
        AnimalRepository.createNode(eventWriter, "takenCareOf", String.valueOf(takenCareOf));
    }

    @Override
    public void decodeFromXml(org.w3c.dom.Element element){
        setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent()));
        setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
        setName(element.getElementsByTagName("name").item(0).getTextContent());
    }

    @Override
    public String toString(){
        return this.name+" "+this.nrOfLegs+" "+this.maintenanceCost+" "+this.dangerPerc+" "+this.takenCareOf;
    }
}
