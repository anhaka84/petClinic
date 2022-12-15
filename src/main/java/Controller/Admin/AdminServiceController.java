package Controller.Admin;

import Entities.ServiceEntity;
import Models.ServiceModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminServiceController implements Initializable {

    @FXML
    private TextField tfServiceId;

    @FXML
    private TextField tfServiceName;

    @FXML
    private TextField tfServiceType;

    @FXML
    private TextField tfServicePrice;

    @FXML
    private TableView<ServiceModel> tableService;

    @FXML
    private TableColumn<ServiceModel, Integer> ColSId;

    @FXML
    private TableColumn<ServiceModel, String> ColSName;

    @FXML
    private TableColumn<ServiceModel, String> ColSType;

    @FXML
    private TableColumn<ServiceModel, Float> ColSPrice;

    private final ServiceEntity serviceEntity = new ServiceEntity();

    private ObservableList<ServiceModel> listService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTableData(serviceEntity.getAllService());
    }

    private void setTableData(ArrayList<ServiceModel> list) {
        listService = FXCollections.observableArrayList(list);
        ColSId.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        ColSName.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        ColSType.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        ColSPrice.setCellValueFactory(new PropertyValueFactory<>("servicePrice"));
        tableService.setItems(listService);
    }

    private void showService() {
        ServiceModel service = getRowData();
        tfServiceId.setText(String.valueOf(service.getServiceId()));
        tfServiceName.setText(service.getServiceName());
        tfServiceType.setText(service.getServiceType());
        tfServicePrice.setText(String.valueOf(service.getServicePrice()));
    }

    private ServiceModel getRowData() {
        ServiceModel service = tableService.getSelectionModel().getSelectedItem();
        return service;
    }
}
