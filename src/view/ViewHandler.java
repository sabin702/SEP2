package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Tabs.EmployeeTabPane.EmployeeTabPaneView;
import viewmodel.ViewModelProvider;

import java.io.IOException;

public class ViewHandler {
    private Stage stage;
    private ViewModelProvider vmp;

    public ViewHandler(Stage stage, ViewModelProvider _vmp) {
        this.stage = stage;
        this.vmp = _vmp;
    }

    public void start() throws Exception{
        openEmployeeTabPane();
    }

    private void openEmployeeTabPane() {
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("tabview/TabView.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmployeeTabPaneView view = loader.getController();
        view.init();
        Scene scene = new Scene(root);
        stage.setTitle("Datavisualizer");

        stage.setScene(scene);
        stage.show();
    }
}
