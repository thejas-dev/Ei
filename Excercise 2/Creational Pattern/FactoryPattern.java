// Factory Patter : Vehicle Factory Application

// Product Interface
interface Vehicle{
	void drive();
}

// Concrete Products
class Car implements Vehicle{
	@Override
	public void drive(){
		System.out.println("Driving a car");
	}
}

class Bike implements Vehicle{
	@Override
	public void drive(){
		System.out.println("Driving a bike");
	}
}


// Factory
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
    	if (type == null) {
            System.out.println("Error: Vehicle type cannot be null.");
            return null;
        }

        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                System.out.println("Error: Unknown vehicle type.");
                return null;
        }
    }
}

// Client Code
public class FactoryPattern{
	public static void main(String[] args){
		Vehicle car = VehicleFactory.createVehicle("car");
		if(car != null)
			car.drive(); // Output: Driving a car.

		Vehicle bike = VehicleFactory.createVehicle("bike");
		if(bike != null)
			bike.drive(); // Output: Riding a bike.

		// Handle unknown vehicle type
        Vehicle truck = VehicleFactory.createVehicle("truck");
        if (truck != null) 
        	truck.drive(); // Will not execute due to unknown type.
        
	}
}

// The VehicleFactory class is responsible for creating instances of Vehicle 
// products (Car and Bike). This pattern encapsulates the creation logic, 
// allowing the client code to request objects without knowing the exact 
// class of the product.