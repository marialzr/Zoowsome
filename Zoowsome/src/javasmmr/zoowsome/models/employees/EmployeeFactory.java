package javasmmr.zoowsome.models.employees;

import javasmmr.zoowsome.services.factories.constants.Constants;

public class EmployeeFactory {
    public EmployeeAbstractFactory getEmployeeFactory(String type){
        if (Constants.FactoryTyes.CaretakersFactory.equals(type)) {
            return new CaretakersFactory();
        }
        return null;
    }
}
