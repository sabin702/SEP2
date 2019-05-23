package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class RootProvider {
    public Parent getAddCarRoot(){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/Tabs/EmployeeTabPane/AddCar/AddCar.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;

    }
}
