package MVVM.viewmodel;

import MVVM.Model.*;
import MVVM.Model.Customer.CustomerModel;
import MVVM.Model.Employee.EmployeeModel;
import MVVM.view.ViewHandler;
import MVVM.viewmodel.AccountAndLogIn.CreateAccountAndLogInViewModel;
import MVVM.viewmodel.AccountAndLogIn.CreateAccountViewModel;
import MVVM.viewmodel.AccountAndLogIn.LogInViewModel;
import MVVM.viewmodel.AccountTab.AccountViewModel;
import MVVM.viewmodel.AccountTab.LogOutViewModel;
import MVVM.viewmodel.CarsTab.AddCarViewModel;
import MVVM.viewmodel.CarsTab.CarsViewModel;

import MVVM.viewmodel.MakeReservationTab.MakeReservationViewModel;
import MVVM.viewmodel.ReservationsTab.ReservationsViewModel;
import MVVM.viewmodel.UsersTab.UsersViewModel;
import MVVM.viewmodel.ViewReservationsTab.ViewReservationsViewModel;

import java.io.Serializable;
import java.rmi.RemoteException;

public class VMProvider implements Serializable {

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
    private LogOutViewModel logOutViewModel;

    private CustomerModel cm;
    private EmployeeModel em;
    private ModelProvider modelProvider;

    public VMProvider(ModelProvider modelProvider) {
        this.modelProvider = modelProvider;
        cm = modelProvider.getCustomerModel();
        em = modelProvider.getEmployeeModel();
    }

    public void instantiateLogInViewModel(ViewHandler viewHandler) {
        if (logInViewModel == null) {
            logInViewModel = new LogInViewModel(viewHandler, cm);
        }
    }
    public void instantiateLogOutViewModel(ViewHandler viewHandler){
        if(logOutViewModel == null){
            logOutViewModel = new LogOutViewModel(viewHandler);
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

    public void instantiateAddCarViewModel(ViewHandler viewHandler) {
        if (addCarViewModel == null) {
            addCarViewModel = new AddCarViewModel(viewHandler,em);
        }
    }

    public void instantiateCarsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (carsViewModel == null) {
            carsViewModel = new CarsViewModel(viewHandler,em);
        }
    }

    public void instantiateAccountViewModel(ViewHandler viewHandler) {
        if (accountViewModel == null) {
            accountViewModel = new AccountViewModel(viewHandler, cm);
        }
        accountViewModel.setUserName(logInViewModel.getUsername());
    }


    public void instantiateMakeReservationViewModel(ViewHandler viewHandler) throws RemoteException {
        if (makeReservationViewModel == null) {
            makeReservationViewModel = new MakeReservationViewModel(viewHandler, cm);
        }
        makeReservationViewModel.setUserName(logInViewModel.getUsername());
    }

    public void instantiateReservationsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (reservationsViewModel == null) {
            reservationsViewModel = new ReservationsViewModel(viewHandler,em);
        }
    }

    public void instantiateUsersViewModel() throws RemoteException {
        if (usersViewModel == null) {
            usersViewModel = new UsersViewModel(em);
        }
    }

    public void instantiateViewReservationsViewModel(ViewHandler viewHandler) throws RemoteException {
        if (viewReservationsViewModel == null) {
            viewReservationsViewModel = new ViewReservationsViewModel(viewHandler,cm);
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

    public LogOutViewModel getLogOutViewModel() {
        return logOutViewModel;
    }
}

