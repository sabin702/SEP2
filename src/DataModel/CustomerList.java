package DataModel;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable {

    private ArrayList<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void addCustomer(int index, Customer customer){
        customers.add(index, customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public void removeCustomer(int index){
        customers.remove(index);
    }

    public int size(){
        return customers.size();
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }
}
