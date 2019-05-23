package view.Tabs.EmployeeTabPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Tabs.EmployeeTabPane.AddCar.AddCarView;


import java.io.IOException;

public class EmployeeTabApplication extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/Tabs/EmployeeTabPane/EmployeeTabPane.fxml"));
        Parent root = loader.load();
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmployeeTabPaneView view = loader.getController();

        Scene scene = new Scene(root);

        stage.setTitle("View tasks");

        stage.setScene(scene);
        stage.show();
    }
    public void openAddCar() throws IOException {
        FXMLLoader loader = new FXMLLoader();


        loader.setLocation(getClass().getResource("/view/Tabs/EmployeeTabPane/AddCar/AddCar.fxml"));
        Parent root = loader.load();
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCarView view = loader.getController();

        Scene scene = new Scene(root);
        stage.setTitle("Add Car");

        stage.setScene(scene);
        stage.show();

    }
}
