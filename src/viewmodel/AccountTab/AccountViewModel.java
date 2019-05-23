package viewmodel.AccountTab;

import view.ViewHandler;

import java.io.IOException;

public class AccountViewModel {
    private ViewHandler viewHandler;

    public void openCreateAccountAndLogin() throws IOException {
        viewHandler.openCreateAccountAndLogIn();

    }
}
