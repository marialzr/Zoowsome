package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.services.factories.constants.Constants;

import java.math.BigDecimal;

public class CaretakersFactory extends EmployeeAbstractFactory {
    @Override
    public Employee getEmployee(String type) {
        BigDecimal nr=new BigDecimal(30);
        if (Constants.EmployeeType.Caretakers.equals(type)){
            return new Caretakers("ana", nr,30);}
        return null;
    }
}
