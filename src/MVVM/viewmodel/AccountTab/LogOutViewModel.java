package MVVM.viewmodel.AccountTab;

import MVVM.view.ViewHandler;

import java.io.IOException;

public class LogOutViewModel {
    ViewHandler viewHandler;

    public LogOutViewModel(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }
    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }
}
