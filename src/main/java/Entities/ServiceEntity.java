package Entities;

import DB.main.DB;
import Models.ServiceModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceEntity {

    private final DB<ServiceModel> db = new DB<>();

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

    public boolean updateService(ServiceModel service) {
        query = "UPDATE Service SET "
                + "service_name = ?,"
                + "service_type = ?,"
                + "service_price = ?"
                + " WHERE service_id = ?";
        condition = Arrays.asList(
                service.getServiceName(),
                service.getServiceType(),
                service.getServicePrice(),
                service.getServiceId()
        );
        return db.setSqlDataRow(query, condition, service);
    }

    public boolean deleteServices(int serviceId) {
        query = "DELETE FROM Service WHERE service_id = ?";
        condition = Arrays.asList(serviceId);
        return db.setSqlDataRow(query, condition, new ServiceModel());
    }
}
