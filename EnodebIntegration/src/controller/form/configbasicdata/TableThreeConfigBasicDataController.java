/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.form.configbasicdata;

import controller.BaseController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.configbasicdata.TableThreeBasicData;
import view.ViewFactory;

/**
 * FXML Controller class
 *
 * @author Miguelangel
 */
public class TableThreeConfigBasicDataController extends BaseController implements Initializable {

    private TableView tableThreeBasicData;

    private TextArea mmlPreviewTableThreeBasicData;

    private boolean isUpdate;

    @FXML
    private TextField locationNameTableThreeConfigBasicData;

    @FXML
    private TextField gcdfTableThreeConfigBasicData;

    @FXML
    private ComboBox parameterIdTableThreeConfigBasicData;

    @FXML
    private TextField latitudeDgTableThreeConfigBasicData;

    @FXML
    private TextField longitudeDgTableThreeConfigBasicData;

    @FXML
    private TextField latitudeSecTableThreeConfigBasicData;

    @FXML
    private TextField longitudSecTableThreeConfigBasicData;

    @FXML
    private TextField locationIdTableThreeConfigBasicData;

    @FXML
    private TextField altitudeTableThreeConfigBasicData;

    @FXML
    private TextField rangeTableThreeConfigBasicData;

    @FXML
    private TextField cityTableThreeConfigBasicData;

    @FXML
    private TextField regionTableThreeConfigBasicData;

    @FXML
    private TextField addressTableThreeConfigBasicData;

    @FXML
    private TextField officeTableThreeConfigBasicData;

    @FXML
    private TextField contactTableThreeConfigBasicData;

    @FXML
    private TextField telephoneTableThreeConfigBasicData;

    @FXML
    private TextField userlabelTableThreeConfigBasicData;

    @FXML
    private TextField preciseTableThreeConfigBasicData;

    public TableThreeConfigBasicDataController(ViewFactory viewFactory, String fxmlName,
            TableView tableThreeBasicData,
            TextArea mmlPreviewTableThreeBasicData,
            boolean isUpdate) {
        super(viewFactory, fxmlName);
        this.tableThreeBasicData = tableThreeBasicData;
        this.mmlPreviewTableThreeBasicData = mmlPreviewTableThreeBasicData;
        this.isUpdate = isUpdate;
    }

    @FXML
    void onCancelTableThreeConfigBasicData(ActionEvent event) {
        viewFactory.closeStage((Stage) preciseTableThreeConfigBasicData.getScene().getWindow());
    }

    @FXML
    void onTableThreeConfigBasicData(ActionEvent event) {
        if (!isUpdate) {
            tableThreeBasicData.getItems().addAll(
                    new TableThreeBasicData(
                            parameterIdTableThreeConfigBasicData.getValue().toString(),
                            locationNameTableThreeConfigBasicData.getText().toUpperCase(),
                            gcdfTableThreeConfigBasicData.getText().toUpperCase(),
                            latitudeDgTableThreeConfigBasicData.getText().toUpperCase(),
                            longitudeDgTableThreeConfigBasicData.getText().toUpperCase(),
                            latitudeSecTableThreeConfigBasicData.getText().toUpperCase(),
                            longitudSecTableThreeConfigBasicData.getText().toUpperCase(),
                            locationIdTableThreeConfigBasicData.getText().toUpperCase(),
                            altitudeTableThreeConfigBasicData.getText().toUpperCase(),
                            rangeTableThreeConfigBasicData.getText().toUpperCase(),
                            cityTableThreeConfigBasicData.getText().toUpperCase(),
                            regionTableThreeConfigBasicData.getText().toUpperCase(),
                            addressTableThreeConfigBasicData.getText().toUpperCase(),
                            officeTableThreeConfigBasicData.getText().toUpperCase(),
                            contactTableThreeConfigBasicData.getText().toUpperCase(),
                            telephoneTableThreeConfigBasicData.getText().toUpperCase(),
                            userlabelTableThreeConfigBasicData.getText().toUpperCase(),
                            preciseTableThreeConfigBasicData.getText().toUpperCase()
                    )
            );
        } else {
            TableThreeBasicData _tableThreeBasicData
                    = (TableThreeBasicData) tableThreeBasicData.getSelectionModel().getSelectedItem();

            _tableThreeBasicData.setParameterId(parameterIdTableThreeConfigBasicData.getValue().toString());
            _tableThreeBasicData.setLocationName(locationNameTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setGcdf(gcdfTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setLatitudeDegFormat(latitudeDgTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setLongitudeDegFormat(longitudeDgTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setLatitudeSecFormat(latitudeSecTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setLongitudeSecFormat(latitudeSecTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setLocationId(locationIdTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setAltitude(altitudeTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setRange(rangeTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setCity(cityTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setRegion(regionTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setAddress(addressTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setOffice(officeTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setContact(contactTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setTelephone(telephoneTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setUserLabel(userlabelTableThreeConfigBasicData.getText().toUpperCase());
            _tableThreeBasicData.setPrecise(preciseTableThreeConfigBasicData.getText().toUpperCase());
            tableThreeBasicData.refresh();

        }
        setTextAreaTableThree();
        viewFactory.closeStage((Stage) preciseTableThreeConfigBasicData.getScene().getWindow());
    }

    private void setTextAreaTableThree() {
        mmlPreviewTableThreeBasicData.clear();
        tableThreeBasicData.getItems().forEach((basicData) -> {
            TableThreeBasicData t = (TableThreeBasicData) basicData;
            if (t.getParameterId().equals("REFERENCE")) {
                mmlPreviewTableThreeBasicData.appendText("//\n");
            }
            if (t.getParameterId().equals("CREATE")) {
                mmlPreviewTableThreeBasicData.appendText(""
                        + "ADD LOCATION:LOCATIONNAME=\"" + t.getLocationName() + "\","
                        + "GCDF=" + t.getGcdf() + ","
                        + "LATITUDEDEGFORMAT=" + t.getLatitudeDegFormat() + ","
                        + "LONGITUDEDEGFORMAT=" + t.getLongitudeDegFormat() + ","
                );
                if (!t.getLatitudeSecFormat().isEmpty()) {
                    mmlPreviewTableThreeBasicData.appendText(
                            "LATITUDESECFORMAT=" + t.getLatitudeSecFormat() + ",");
                }
                if (!t.getLongitudeSecFormat().isEmpty()) {
                    mmlPreviewTableThreeBasicData.appendText(
                            "LONGITUDESECFORMAT=" + t.getLatitudeSecFormat() + ",");
                }
                mmlPreviewTableThreeBasicData.appendText(
                        "LOCATIONID=" + t.getLocationId() + ","
                        + "ALTITUDE=" + t.getAltitude() + ","
                        + "RANGE=" + t.getRange() + ","
                        + "CITY=" + t.getCity() + ","
                        + "ADDRESS=" + t.getAddress() + ","
                        + "OFFICE=" + t.getOffice() + ","
                        + "CONTACT=" + t.getContact() + ","
                        + "TELEPHONE=" + t.getTelephone() + ","
                        + "USERLABEL=" + t.getUserLabel() + ","
                        + "PRECISE=" + t.getPrecise() + ";\n"
                );
            }

            if (t.getParameterId().equals("DELETE")) {
                mmlPreviewTableThreeBasicData.appendText(
                        "RMV LOCATION:LOCATIONNAME=\"" + t.getLocationName() + "\";\n"
                );
            }

        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        parameterIdTableThreeConfigBasicData.getItems().addAll(
                "REFERENCE",
                "CREATE",
                "DELETE"
        );

        if (isUpdate) {
            TableThreeBasicData _tableThreeBasicData
                    = (TableThreeBasicData) tableThreeBasicData.getSelectionModel().getSelectedItem();
            parameterIdTableThreeConfigBasicData.setValue(_tableThreeBasicData.getParameterId());
            locationNameTableThreeConfigBasicData.setText(_tableThreeBasicData.getLocationName());
            gcdfTableThreeConfigBasicData.setText(_tableThreeBasicData.getGcdf());
            latitudeDgTableThreeConfigBasicData.setText(_tableThreeBasicData.getLatitudeDegFormat());
            longitudeDgTableThreeConfigBasicData.setText(_tableThreeBasicData.getLongitudeDegFormat());
            latitudeSecTableThreeConfigBasicData.setText(_tableThreeBasicData.getLatitudeSecFormat());
            longitudSecTableThreeConfigBasicData.setText(_tableThreeBasicData.getLongitudeSecFormat());
            locationIdTableThreeConfigBasicData.setText(_tableThreeBasicData.getLocationId());
            altitudeTableThreeConfigBasicData.setText(_tableThreeBasicData.getAltitude());
            rangeTableThreeConfigBasicData.setText(_tableThreeBasicData.getRange());
            cityTableThreeConfigBasicData.setText(_tableThreeBasicData.getCity());
            regionTableThreeConfigBasicData.setText(_tableThreeBasicData.getRegion());
            addressTableThreeConfigBasicData.setText(_tableThreeBasicData.getAddress());
            officeTableThreeConfigBasicData.setText(_tableThreeBasicData.getOffice());
            contactTableThreeConfigBasicData.setText(_tableThreeBasicData.getContact());
            telephoneTableThreeConfigBasicData.setText(_tableThreeBasicData.getTelephone());
            userlabelTableThreeConfigBasicData.setText(_tableThreeBasicData.getUserLabel());
            preciseTableThreeConfigBasicData.setText(_tableThreeBasicData.getPrecise());
        } else {
            parameterIdTableThreeConfigBasicData.setValue("REFERENCE");
        }
    }

}
