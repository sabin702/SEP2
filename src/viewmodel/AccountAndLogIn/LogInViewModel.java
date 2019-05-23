package viewmodel.AccountAndLogIn;

import view.ViewHandler;

import java.io.IOException;

public class LogInViewModel {
    private ViewHandler viewHandler;
    public LogInViewModel (ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }
    public void openCustomerTabPane() throws IOException {
        viewHandler.openCustomerTabPane();

    }
}
