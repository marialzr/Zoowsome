package javasmmr.zoowsome.repositories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Butterfly;
import javasmmr.zoowsome.models.employees.Caretakers;
import javasmmr.zoowsome.models.employees.Employee;
import javasmmr.zoowsome.services.factories.constants.Constants;

public class EmployeeRepository extends EntityRepository<Employee> {
    public EmployeeRepository(){
        super("Employees.xml", Constants.XML_TAGS.EMPLOYEE);
    }
    @Override
    public Employee getEntityFromXmlElement(org.w3c.dom.Element element){
        String discriminant=element.getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
        switch(discriminant){
            case Constants.EmployeeType.Caretakers:
                Employee caretaker=new Caretakers();
                caretaker.decodeFromXml(element);
                return caretaker;
            default: //you must also chech for all types of animals from all subclasses of animal
                break;
        }
        return null;
    }
}
