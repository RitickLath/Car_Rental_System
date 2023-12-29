import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car{
    private String id;
    private String Model;
    private String Brand;
    private float BasePrice;
    private boolean IsAvailable;

    Car(String id , String Model , String Brand , float BasePrice , boolean IsAvailable){
        this.id = id;
        this.Model = Model;
        this.Brand = Brand;
        this.BasePrice = BasePrice;
        this.IsAvailable = IsAvailable;
    }

    void rent(){
        IsAvailable = false;
    }

    void returnCar(){
        IsAvailable = true;
    }

    double priceTotal(int days){
        return days * BasePrice;
    }

    // Getter for all private variables
    String getId(){
        return id;
    }

    String getModel(){
        return Model;
    }
    String getBrand(){
        return Brand;
    }

    float getBasePrice(){
        return BasePrice;
    }

    boolean getIsAvailable(){
        return IsAvailable;
    }

}

class Customer{
    private String CustomerName;
    private String CustomerId;
    private String PhNumber;

    Customer(String CustomerName , String CustomerId){
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        
    }

    public String getCustomerName(){
        return CustomerName;
    }

    public String getCustomerId(){
        return CustomerId;
    }


}


class Rental{
    private  Car car;
    private Customer customer;
    private int days;

    public Rental(Car car , Customer customer , int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }

    public Customer getCustomer(){
        return customer;
    }

    public int getdays(){
        return days;
    }

}


// to store the data of cars we have best option to use is database but we don't know database now so we have arraylist as best option

class CarRentalSystem{
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }


    // someone come to ask for renting a car with specific car class details day and customer class
    public void rentCar(Car car , Customer customer , int days){
        if(car.getIsAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else{
            System.out.println("Car is not available for rent");;
        }
    }

    public void returnRentCar(Car car){
        car.returnCar();
        Rental rentalToRemove = null;
        for(Rental rental: rentals){
            if(rental.getCar().equals(car)){
                rentalToRemove = rental;
                break;
        }
        }

        if(rentalToRemove !=null){
            rentals.remove(rentalToRemove);
            System.out.println("Car Returned Successfully");
        }
        else{
            System.out.println("Car was not rented");
        }
    }

    public void menu(){
        Scanner s = new Scanner(System.in);

        while(true){
            System.out.println("===== Car Rental System =====");

            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

            int choice = s.nextInt();
            s.nextLine();

            if(choice == 1){
                System.out.println("\n==Rent a Car");
                System.out.print("Enter your Name: ");
                String name = s.nextLine();

                System.out.println("\nAvailable Cars");
                for(Car car: cars){
                    if (car.getIsAvailable()) {
                        System.out.println(car.getId() + " - " + car.getBasePrice() + " - " + car.getModel());

                    }
                }
                System.out.println("Enter the car I'd if you want to Rent: ");
                String carid = s.nextLine();

                System.out.println("Enter the number of days you want to Rent: ");
                int rentaldays = s.nextInt();
                s.nextLine();

                Customer newCustomer = new Customer(name , "CUS" + (customers.size()+1) );
                addCustomer(newCustomer);

                Car selectedCar = null;

                for(Car car : cars){
                    if(car.getId().equals(carid) && car.getIsAvailable()){
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.priceTotal(rentaldays);
                    System.out.println("\n== Rental Information --\n");
                    System.out.println("Customer Id: " + newCustomer.getCustomerName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days: " + rentaldays);
                    System.out.println("Total Price: " + totalPrice);

                    System.out.printf("\nConfirm rental (Y/N): ");
                    String confirm = s.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentaldays);
                        System.out.println("Car Rented Successfully");
                    }
                    else{
                        System.out.println("Rental Cancelled");
                    }
                }
                else{
                    System.out.println("Invalid Car Selected or Car not availabe for Rent");
                }

            }
            else if(choice == 2){
                System.out.println("\n== Return a Car==\n");
                System.out.println("Enter the car id you want to return: ");
                String carid = s.nextLine();

                Car carToReturn = null;
                for(Car car: cars){
                    if(car.getId().equals(carid) && !car.getIsAvailable()){
                        carToReturn = car;
                        break;
                    }
                }

                if(carToReturn != null){
                    returnRentCar(carToReturn);
                    System.out.println("Car Returned Succefully");
                }
                else{
                    System.out.println("Car was not rented info is missing");
                }
            }
            else if(choice == 3){
            break;
        }
            else{
            System.out.println("Invalid request");
        }
            
        }
        

    }
}

public class Car_Rental {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Camry", 60, true);
        Car car2 = new Car("C002", "Honda", "Accord", 70, true);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150, true);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}