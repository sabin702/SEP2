package viewmodel;



import Model.*;
import view.ViewHandler;
import viewmodel.AccountAndLogIn.CreateAccountAndLogInViewModel;
import viewmodel.AccountAndLogIn.CreateAccountViewModel;
import viewmodel.AccountAndLogIn.LogInViewModel;
import viewmodel.AccountTab.AccountViewModel;
import viewmodel.CarsTab.AddCarViewModel;
import viewmodel.CarsTab.CarsViewModel;

import viewmodel.MakeReservationTab.MakeReservationViewModel;
import viewmodel.ReservationsTab.ReservationsViewModel;
import viewmodel.UsersTab.UsersViewModel;
import viewmodel.ViewReservationsTab.ViewReservationsViewModel;

import java.io.Serializable;
import java.rmi.RemoteException;

public class ViewModelProvider implements Serializable {

    private LogInViewModel logInViewModel;
    private CreateAccountAndLogInViewModel createAccountAndLogInViewModel;
    private CreateAccountViewModel createAccountViewModel;
    private AddCarViewModel addCarViewModel;
    private CarsViewModel carsViewModel;
    private AccountViewModel accountViewModel;
    private MakeReservationViewModel makeReservationViewModel;
    private ReservationsViewModel reservationsViewModel;
    private UsersViewModel usersViewModel;
    private ViewReservationsViewModel viewReservationsViewModel;

    private CustomerModel cm;
    private EmployeeModel em;
    private ModelProvider modelProvider;

    public ViewModelProvider(ModelProvider modelProvider) {
        this.modelProvider = modelProvider;
        cm = modelProvider.getCustomerModel();
        em = modelProvider.getEmployeeModel();
    }

    public void instantiateLogInViewModel(ViewHandler viewHandler) {
        if (logInViewModel == null) {
            logInViewModel = new LogInViewModel(viewHandler, cm);
        }
    }

    public void instantiateCreateAccountAndLogInViewModel(ViewHandler viewHandler) {
        if (createAccountAndLogInViewModel == null) {
            createAccountAndLogInViewModel = new CreateAccountAndLogInViewModel(viewHandler);
        }
    }

    public void instantiateCreateAccountViewModel(ViewHandler viewHandler) {
        if (createAccountViewModel == null) {
            createAccountViewModel = new CreateAccountViewModel(viewHandler, cm);
        }
    }

    public void instantiateAddCarViewModel() {
        if (addCarViewModel == null) {
            addCarViewModel = new AddCarViewModel(em);
        }
    }

    public void instantiateCarsViewModel() throws RemoteException {
        if (carsViewModel == null) {
            carsViewModel = new CarsViewModel(em);
        }
    }

    public void instantiateAccountViewModel(ViewHandler viewHandler) {
        if (accountViewModel == null) {
            accountViewModel = new AccountViewModel(viewHandler, cm);
        }
        accountViewModel.setUserName(logInViewModel.getUsername());
    }


    public void instantiateMakeReservationViewModel(ViewHandler viewHandler) {
        if (makeReservationViewModel == null) {
            makeReservationViewModel = new MakeReservationViewModel(viewHandler, cm);
        }
        makeReservationViewModel.setUserName(logInViewModel.getUsername());
    }

    public void instantiateReservationsViewModel() throws RemoteException {
        if (reservationsViewModel == null) {
            reservationsViewModel = new ReservationsViewModel(em);
        }
    }

    public void instantiateUsersViewModel() {
        if (usersViewModel == null) {
            usersViewModel = new UsersViewModel(em);
        }
    }

    public void instantiateViewReservationsViewModel() throws RemoteException {
        if (viewReservationsViewModel == null) {
            viewReservationsViewModel = new ViewReservationsViewModel(cm);
        }
    }


    public LogInViewModel getLogInViewModel() {
        return logInViewModel;
    }

    public CreateAccountAndLogInViewModel getCreateAccountAndLogInViewModel() {
        return createAccountAndLogInViewModel;
    }

    public CreateAccountViewModel getCreateAccountViewModel() {
        return createAccountViewModel;
    }

    public AddCarViewModel getAddCarViewModel() {
        return addCarViewModel;
    }

    public CarsViewModel getCarsViewModel() {
        return carsViewModel;
    }

    public AccountViewModel getAccountViewModel() {
        return accountViewModel;
    }

    public MakeReservationViewModel getMakeReservationViewModel() {
        return makeReservationViewModel;
    }

    public ReservationsViewModel getReservationsViewModel() {
        return reservationsViewModel;
    }

    public UsersViewModel getUsersViewModel() {
        return usersViewModel;
    }

    public ViewReservationsViewModel getViewReservationsViewModel() {
        return viewReservationsViewModel;
    }
}

