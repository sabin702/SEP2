package viewmodel;


import view.Tabs.EmployeeTabPane.AddCar.AddCarView;
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


    public void instantiateViewModels(ViewHandler viewHandler){

        logInViewModel = new LogInViewModel(viewHandler);
        createAccountAndLogInViewModel = new CreateAccountAndLogInViewModel(viewHandler);
        createAccountViewModel = new CreateAccountViewModel(viewHandler);
        addCarViewModel = new AddCarViewModel(viewHandler);
        carsViewModel = new CarsViewModel(viewHandler);
        accountViewModel = new AccountViewModel();
        makeReservationViewModel = new MakeReservationViewModel(viewHandler);
        reservationsViewModel = new ReservationsViewModel();
        usersViewModel = new UsersViewModel(viewHandler);
        viewReservationsViewModel = new ViewReservationsViewModel();
    }

    /*public void instantiateCustomerTabPanelViewModel() {

    }

    public void instantiateLogInViewModel() {

    }

    public void instantiateCreateAccountAndLogInViewModel() {

    }

    public void instantiateCreateAccountViewModel() {

    }

    public void instantiateAddCarViewModel() {

    }

    public void instantiateCarsViewModel() {

    }

    public void instantiateAccountViewModel() {

    }

    public void instantiateEmployeeTabPaneViewModel() {

    }

    public void instantiateMakeReservationViewModel() {

    }

    public void instantiateReservationsViewModel() {

    }

    public void instantiateUsersViewModel() {

    }

    public void instantiateViewReservationsViewModel() {

    }*/



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

