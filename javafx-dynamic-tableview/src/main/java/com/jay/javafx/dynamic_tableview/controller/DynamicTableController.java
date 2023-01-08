package com.jay.javafx.dynamic_tableview.controller;

import com.jay.javafx.dynamic_tableview.jdbc.JDBCUtil;
import com.jay.javafx.dynamic_tableview.util.ControllerUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DynamicTableController implements Initializable {
    private static Logger logger = LoggerFactory.getLogger(DynamicTableController.class);
    @FXML
    private TableView customerTable;

    private JDBCUtil jdbcUtils = new JDBCUtil();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildData();
    }

    public void buildData() {
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = jdbcUtils.getCustomers();
            if (null != rs) {
                /**
                 * ********************************
                 * TABLE COLUMN ADDED DYNAMICALLY *
                 *********************************
                 */
                for (int cIndex = 0; cIndex < rs.getMetaData().getColumnCount(); cIndex++) {
                    //We are using non property style for making dynamic table
                    final int j = cIndex;
                    TableColumn col = new TableColumn(rs.getMetaData().getColumnName(cIndex + 1));
                    col.setCellFactory(TextFieldTableCell.forTableColumn());

                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });
                    customerTable.getColumns().addAll(col);
                    logger.info("Column [{}]", cIndex);
                }

                /**
                 * ******************************
                 * Data added to ObservableList *
                 *******************************
                 */
                while (rs.next()) {
                    //Iterate Row
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int rIndex = 1; rIndex <= rs.getMetaData().getColumnCount(); rIndex++) {
                        //Iterate Column
                        row.add(rs.getString(rIndex));
                    }
                    logger.info("Row [1] added: {}", row);
                    data.add(row);

                }
                //FINALLY ADDED TO TableView
                customerTable.setEditable(true);
                customerTable.setItems(data);
            }
        } catch (Exception exception) {
            logger.error("Failed to render", exception);
        }
    }
}
