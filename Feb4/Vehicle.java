class Vehicle{
        static double registrationFee=150.00;
        String ownerName;
	String vehicleType;
        int registrationNumber;
        Vehicle(String ownerName, String vehicleType, final int registrationNumber){
                this.ownerName=ownerName;
                this.vehicleType=vehicleType;
		this.registrationNumber=registrationNumber;
        }
        public static void updateRegistrationFee(double updatedFee){
		registrationFee=updatedFee;
                System.out.println("The new updated registration fees is:"+registrationFee);
        }
        public static void main(String args[]){
                Vehicle object=new Vehicle("Raj","Sedan",500);
                new Vehicle("Rashmika","SUV",400);
		if(object instanceof Vehicle){
			System.out.println("Object is an instance of Vehicle class");
		}
		else{
			System.out.println("Object is not an instance of Vehicle class");
		}
                Vehicle.updateRegistrationFee(200.00);
        }
}
