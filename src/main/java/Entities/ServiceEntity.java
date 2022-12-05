package Entities;

import DB.main.DB;
import Models.ServiceModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceEntity {

    DB<ServiceModel> db = new DB<>();
//    ServiceModel serviceModel = new ServiceModel();

    private String query;
    private List condition;
    private final String columns = " ("
            + "service_name,"
            + "service_type,"
            + "service_price"
            + ") ";

    public ServiceEntity() {
    }

    public boolean addService(ServiceModel service) {
        query = "INSERT INTO Service" + columns
                + "VALUES (?,?,?)";
        condition = Arrays.asList(
                service.getServiceName(),
                service.getServiceType(),
                service.getServicePrice()
        );
        return db.setSqlDataRow(query, condition, service);
    }

    public ServiceModel getOneService(int id) {
        query = "SELECT * FROM Service WHERE service_id = ?";
        condition = Arrays.asList(id);
        return db.getOne(query, condition, new ServiceModel());
    }

    public ArrayList<ServiceModel> getAllService() {
        query = "SELECT * FROM Service";
        return db.getAll(query, new ServiceModel());
    }
    
//    public 
}
