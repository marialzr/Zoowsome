package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.interfaces.Caretaker_I;
import javasmmr.zoowsome.repositories.EmployeeRepository;
import javasmmr.zoowsome.services.factories.constants.Constants;
import org.w3c.dom.Element;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;

public class Caretakers extends Employee implements Caretaker_I {
    double workingHours;

    public Caretakers(){
        super("", new BigDecimal(0));
        this.workingHours=0;
    }
    public Caretakers(String name, BigDecimal salary, double workingHours){
        super(name, salary);
        this.workingHours=workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getWorkingHours() {
        return workingHours;
    }


    @Override
    public String takeCareOf(Animal animal) {
        if (animal.kill()){
            return Constants.Caretakers.TCO_KILLED;
        }
        if (this.workingHours<animal.getMaintenanceCost()){
            return Constants.Caretakers.TCO_NO_TIME;
        }
        animal.setTakenCareOf(true);

        double wh=animal.getMaintenanceCost()-this.workingHours;
        this.setWorkingHours(wh);
        return Constants.Caretakers.TCO_SUCCESS;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        super.encodeToXml(eventWriter);
        EmployeeRepository.createNode(eventWriter, "workingHours", String.valueOf(workingHours));
    }

    @Override
    public void decodeFromXml(org.w3c.dom.Element element){
        super.decodeFromXml(element);
        setWorkingHours(Double.valueOf(element.getElementsByTagName("workingHours").item(0).getTextContent()));
    }

}
