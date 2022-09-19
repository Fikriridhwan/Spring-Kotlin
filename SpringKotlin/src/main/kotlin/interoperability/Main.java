package interoperability;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CustomerDatabase db = new CustomerDatabase();


//        Customer phil = new Customer(0,null); java tidak notice error. padahal perlu set value
        Customer phil = new Customer(0,"phil");
        CustomerDatabase db = new CustomerDatabase();
        List<Customer> customers = db.getCustomer();
        try {
            db.addCustomer(phil);
        }catch (IllegalAccessException e){
            System.out.println("exception");
        }
        for (Customer c : db.getCustomer()) {
            System.out.println(c);
        }

        CustomerDatabase.helloWorld();
    }
}
