package viewmodel;



import Model.CustomerModel;
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

public class ViewModelProvider {

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

    public ViewModelProvider(CustomerModel cm) {
        this.cm = cm;
    }

    public void instantiateLogInViewModel(ViewHandler viewHandler) {
        if (logInViewModel == null) {
            logInViewModel = new LogInViewModel(viewHandler);
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
            addCarViewModel = new AddCarViewModel(viewHandler);
        }
    }

    public void instantiateCarsViewModel() {
        if (carsViewModel == null) {
            carsViewModel = new CarsViewModel();
        }
    }

    public void instantiateAccountViewModel(ViewHandler viewHandler) {
        if (accountViewModel == null) {
            accountViewModel = new AccountViewModel(viewHandler);
        }
    }


    public void instantiateMakeReservationViewModel() {
        if (makeReservationViewModel == null) {
            makeReservationViewModel = new MakeReservationViewModel();
        }
    }

    public void instantiateReservationsViewModel() {
        if (reservationsViewModel == null) {
            reservationsViewModel = new ReservationsViewModel();
        }
    }

    public void instantiateUsersViewModel() {
        if (usersViewModel == null) {
            usersViewModel = new UsersViewModel();
        }
    }

    public void instantiateViewReservationsViewModel() {
        if (viewReservationsViewModel == null) {
            viewReservationsViewModel = new ViewReservationsViewModel();
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

