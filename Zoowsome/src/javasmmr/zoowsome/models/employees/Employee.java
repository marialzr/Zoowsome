package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.models.interfaces.XML_Parsable;
import javasmmr.zoowsome.repositories.AnimalRepository;
import javasmmr.zoowsome.repositories.EmployeeRepository;
import sun.management.snmp.jvmmib.EnumJvmMemoryGCVerboseLevel;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;

public abstract class Employee implements XML_Parsable{
    String name;
    Long id;
    BigDecimal salary;
    boolean isDead;

    public Employee(String name, BigDecimal salary){
        long numb=-1;
        while (true) {
            numb = (long)(Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13 digit number.
            if (String.valueOf(numb).length() == 13){
                break;
            }
        }
        this.id=numb;
        this.name=name;
        this.isDead=false;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
        EmployeeRepository.createNode(eventWriter, "isDead", String.valueOf(isDead));
        EmployeeRepository.createNode(eventWriter, "name", String.valueOf(name));
        EmployeeRepository.createNode(eventWriter, "id", String.valueOf(id));
        EmployeeRepository.createNode(eventWriter,"salary", String.valueOf(salary));
    }

    @Override
    public void decodeFromXml(org.w3c.dom.Element element){
        setDead(Boolean.valueOf(element.getElementsByTagName("isDead").item(0).getTextContent()));
        setName(String.valueOf(element.getElementsByTagName("name").item(0).getTextContent()));
        setId(Long.valueOf(element.getElementsByTagName("id").item(0).getTextContent()));
        String s=element.getElementsByTagName("salary").item(0).getTextContent();
        BigDecimal bd=new BigDecimal(s);  //convert a string to big decimal
        setSalary(bd);
    }
}
