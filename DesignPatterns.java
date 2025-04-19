public class DesignPatterns {
    //---------------------------------------------------------------------------Creational Design Patterns--------------------------
     // ********************   1. Singleton Pattern ***********************
      
    // public static void main(String[] args) {
    //     Singleton s1 = Singleton.getInstance();
    //     Singleton s2 = Singleton.getInstance();
        
    //     if(s1 == s2) {
    //         System.out.println("Singleton works, both are the same instance");
    //     } else {
    //         System.out.println("Singleton failed, different instances");
    //     }
    // }
    
    // static class Singleton {
    //     //instance in layman terms means a copy of the class that has actual values for its variables
    //     private static volatile Singleton instance;
    //     private static synchronized Singleton getInstance() {
    //         if(instance == null) {
    //             instance = new Singleton();
    //         }
    //         return instance;
    //     }
        
    //     private Singleton() {}

    // }

//     // 2. ************ Factory Pattern ***********************
// interface Vehicle {
//     void drive();
// }

// static class Car implements Vehicle {
//     public void drive() {
//         System.out.println("Driving a Car...");
//     }
// }

// static class Bike implements Vehicle {
//     public void drive() {
//         System.out.println("Riding a Bike...");
//     }
// }

// class VehicleFactory {
//     public static Vehicle getVehicle(String type) {
//         if (type.equalsIgnoreCase("car")) {
//             return new Car();
//         } else if (type.equalsIgnoreCase("bike")) {
//             return new Bike();
//         }
//         return null;
//     }
// }
//     public static void main(String[] args) {
//         Vehicle myCar = VehicleFactory.getVehicle("car");
//         myCar.drive(); // Output: Driving a Car...

//         Vehicle myBike = VehicleFactory.getVehicle("bike");
//         myBike.drive(); // Output: Riding a Bike...
//     }

//     // 3. ************ Builder Pattern ***********************
    // public static  class car {
    //     static int wheels;
    //     static String color;
    //     static String engine;
    //     static String model;
    //     private car(Builder builder) {
    //         this.wheels = builder.wheels;
    //         this.color = builder.color;
    //         this.engine = builder.engine;
    //         this.model = builder.model;
    //     }
    //     public static void display(){
    //         System.out.println("Car Model: " + model);
    //         System.out.println("Car Color: " + color);
    //         System.out.println("Car Engine: " + engine);
    //         System.out.println("Car Wheels: " + wheels);
    //     }
    //     public static class Builder{
    //         static int wheels;
    //     static String color;
    //     static String engine; // optional
    //     static String model; // optional;
    //         public Builder setWheels(int wheels, String color) {
    //             this.wheels = wheels;
    //             this.color = color;
    //             return this;
    //         }
    //         public Builder setEngine(String engine) {
    //             this.engine = engine;
    //             return this;
    //         }
    //         public Builder setModel(String model) {
    //             this.model = model;
    //             return this;
    //         }
    //         public car build() {
    //             return new car(this);
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     car myCar = new car.Builder()
    //             .setWheels(4, "Red")
    //             .setEngine("V8")
    //             .setModel("Mustang")
    //             .build();
    //     myCar.display();
    // }

    //--------------------------------------------------------------------------Strctureal Design Patterns--------------------------
    // 4. ************ Adapter Pattern ***********************
    // //1. output ? 
    // interface car{
    //     void drive();
    // }
    // static class  oldCar{
    //     void driveOldCar(){
    //         System.out.println("Driving old car");
    //     }
    // }
    // static class  Adapter implements car{
    //     private oldCar oldCar;
    //     public Adapter(oldCar oldCar){
    //         this.oldCar = oldCar;
    //     }
    //     //This Java method, drive(), is part of the Adapter class and implements the drive() method from the car interface. When called, it delegates the driving action t
    //     // an instance of the oldCar class, calling its driveOldCar() method.
    //     @Override
    //     public void drive() {
    //         oldCar.driveOldCar();
    //     }

        
    // }
    // public static void main(String[] args) {
    //     oldCar oldCar = new oldCar();
    //     car myCar = new Adapter(oldCar);
    //     myCar.drive(); // Output: Driving old car
    // }


    // 5. ************ Decorator Pattern ***********************
    // interface Car {
    //     void drive();
    // }
    // static class BasicCar implements Car {
    //     public void drive() {
    //         System.out.println("Driving a basic car...");
    //     }
    // }
    // static class LuxuryCar implements Car {
    //     private Car car;
    //     public LuxuryCar(Car car) {
    //         this.car = car;
    //     }
    //     public void drive() {
    //         car.drive();
    //         System.out.println("Driving a luxury car...");
    //     }
    // }
    // public static void main(String[] args) {
    //     Car basicCar = new BasicCar();
    //     Car luxuryCar = new LuxuryCar(basicCar);
    //     luxuryCar.drive(); // Output: Driving a basic car... Driving a luxury car...
    // }

    // 6. ************ Strategy Pattern ***********************
    // interface PaymentStrategy {
    //     void pay(int amount);
    // }
    // static class CreditCardPayment implements PaymentStrategy {
    //     private String cardNumber;
    
    //     public CreditCardPayment(String cardNumber) {
    //         this.cardNumber = cardNumber;
    //     }
    
    //     @Override
    //     public void pay(int amount) {
    //         System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
    //     }
    // }
    // static class UPI implements PaymentStrategy {
    //     private String phone;
    
    //     public UPI(String phone) {
    //         this.phone = phone;
    //     }
    
    //     @Override
    //     public void pay(int amount) {
    //         System.out.println("Paid ₹" + amount + " using UPI: " + phone );
    //     }
    // }
    // static class PaymentProcessor {
    //     private PaymentStrategy paymentStrategy;
    
    //     // Set the payment method dynamically
    //     public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
    //         this.paymentStrategy = paymentStrategy;
    //     }
    
    //     // Execute the selected payment method
    //     public void processPayment(int amount) {
    //         if (paymentStrategy == null) {
    //             System.out.println("No payment method selected!");
    //         } else {
    //             paymentStrategy.pay(amount);
    //         }
    //     }
    // }
    // public static void main(String[] args) {
    //     PaymentProcessor paymentProcessor = new PaymentProcessor();

    //     // 1️⃣ Pay using Credit Card
    //     paymentProcessor.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
    //     paymentProcessor.processPayment(5000);

    //     // 3️⃣ Pay using UPI
    //     paymentProcessor.setPaymentStrategy(new UPI("user@upi"));
    //     paymentProcessor.processPayment(1500);
    // }


}
