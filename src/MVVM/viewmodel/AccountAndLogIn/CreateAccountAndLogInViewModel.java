package MVVM.viewmodel.AccountAndLogIn;

import MVVM.view.ViewHandler;

import java.io.IOException;

public class CreateAccountAndLogInViewModel {
    private ViewHandler viewHandler;
    public CreateAccountAndLogInViewModel(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
    }
    public void openCreateAccount() throws IOException {
        viewHandler.openCreateAccount();
    }
    public void openLogIn() throws IOException {
        viewHandler.openLogIn();
    }
}
