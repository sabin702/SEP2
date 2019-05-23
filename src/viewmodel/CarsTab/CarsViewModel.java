package viewmodel.CarsTab;

import view.ViewHandler;

import java.io.IOException;

public class CarsViewModel {
    private ViewHandler viewHandler;
    public CarsViewModel (){

    }

    public void openAddCar() throws IOException {
        viewHandler.openAddCar();

    }
}
