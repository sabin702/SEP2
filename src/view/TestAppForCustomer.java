package view;

import javafx.application.Application;
import javafx.stage.Stage;

import viewmodel.ViewModelProvider;

public class TestAppForCustomer extends Application {
    public void start(Stage stage) throws Exception {

        ViewModelProvider vmp = new ViewModelProvider();
        ViewHandler mv = new ViewHandler(stage,vmp);
        mv.startCustomer();




    }
}
