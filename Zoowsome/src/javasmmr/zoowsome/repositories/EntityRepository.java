package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Butterfly;
import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class EntityRepository<T extends XML_Parsable> {
    private final String XML_FILENAME;
    private final String entityTag;

    public EntityRepository(String xmlfilename, String entityTag){
        this.entityTag=entityTag;
        this.XML_FILENAME=xmlfilename;
    }

    public void save(ArrayList<T> entities) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();  //cannot create event writer without this
        //create a XMLEventWriter
        XMLEventWriter eventWriter=outputFactory.createXMLEventWriter(new FileOutputStream(XML_FILENAME));
        //create an EventFactory
        XMLEventFactory eventFactory=XMLEventFactory.newInstance();
        XMLEvent end=eventFactory.createDTD("\n");

        //create and write start tag
        StartDocument startDocument=eventFactory.createStartDocument();
        eventWriter.add(startDocument);

        //create content open tag
        StartElement configStartElement=eventFactory.createStartElement("", "", "content");
        eventWriter.add(configStartElement);
        eventWriter.add(end);

        for (XML_Parsable entity:entities){
            //<ANIMAL>
            StartElement sElement=eventFactory.createStartElement("", "", this.entityTag);
            eventWriter.add(sElement);
            eventWriter.add(end);

            entity.encodeToXml(eventWriter);

            //</ANIMAL>
            EndElement endElement=eventFactory.createEndElement("", "", this.entityTag);
            eventWriter.add(endElement);
            eventWriter.add(end);
        }

        eventWriter.add(eventFactory.createEndElement("", "", "content"));
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }

    public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        //ex: <dangerPerc>0.15</dangerPerc> ; name=dangerPerc, value=0.15
        XMLEventFactory eventFactory=XMLEventFactory.newInstance();
        XMLEvent end=eventFactory.createDTD("\n");
        XMLEvent tab=eventFactory.createDTD("\t");
        //create start node
        StartElement sElement=eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        //create content
        Characters characters=eventFactory.createCharacters(value);
        eventWriter.add(characters);
        //create end node
        EndElement endElement=eventFactory.createEndElement("", "", name);
        eventWriter.add(endElement);
        eventWriter.add(end);
    }

    //loads an array of animals from a xml files
    public ArrayList<T> load() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<T> entities=new ArrayList<T>();

        File fXmlFile=new File(XML_FILENAME);
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc=db.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList=doc.getElementsByTagName(entityTag);

        for (int i=0; i<nodeList.getLength(); i++){
            Node node=nodeList.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                org.w3c.dom.Element element=(org.w3c.dom.Element)node;
                entities.add(this.getEntityFromXmlElement(element));  //polymorphism->it's abstract method in EntityRepository
            }
        }
        return entities;
    }

    protected abstract T getEntityFromXmlElement(Element element);

}
