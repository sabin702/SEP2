package viewmodel.AccountAndLogIn;

import view.CreateAccountAndLogIn.CreateAccountView;
import view.ViewHandler;

import java.io.IOException;

public class CreateAccountViewModel {
    private ViewHandler viewHandler;
    public CreateAccountViewModel(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }
    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }
}
