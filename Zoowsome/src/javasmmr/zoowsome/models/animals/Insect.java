package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.repositories.AnimalRepository;

import javax.swing.text.Element;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

public class Insect extends Animal {
    protected boolean canFly;
    protected boolean isDangerous;

    public Insect(double maintenance, double danger){
        super(maintenance, danger);
    }

    public boolean isCanFly() {
        return canFly;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        AnimalRepository.createNode(eventWriter, "canFly", String.valueOf(canFly));
        AnimalRepository.createNode(eventWriter, "isDangerous", String.valueOf(isDangerous));
    }

    @Override
    public void decodeFromXml(org.w3c.dom.Element element){
        setCanFly(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent()));
        setDangerous(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent() ));
    }

    @Override
    public String toString(){
        super.toString();
        return this.canFly+" "+this.isDangerous;
    }
}
