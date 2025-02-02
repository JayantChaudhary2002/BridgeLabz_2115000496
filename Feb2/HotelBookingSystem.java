import java.util.*;
class HotelBookingSystem{
	private String guestName;
    	private String roomType;
    	private int nights;
	public HotelBookingSystem(){
        	this.guestName = "Unknown";
        	this.roomType = "Standard";
        	this.nights = 1;
    	}
	public HotelBookingSystem(String guestName, String roomType, int nights){
        	this.guestName = guestName;
        	this.roomType = roomType;
        	this.nights = nights;
    	}
	public HotelBookingSystem(HotelBookingSystem other){
        	this.guestName = other.guestName;
        	this.roomType = other.roomType;
        	this.nights = other.nights;
    	}
	public void display(){
        	System.out.println("Guest Name: " + guestName);
        	System.out.println("Room Type: " + roomType);
        	System.out.println("Nights: " + nights);
    	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		String roomType=sc.nextLine();
		int nights=sc.nextInt();
        	HotelBookingSystem booking1 = new HotelBookingSystem();
        	System.out.println("Booking 1 Details:");
        	booking1.display();
		HotelBookingSystem booking2 = new HotelBookingSystem(name,roomType,nights);
        	System.out.println("\nBooking 2 Details:");
       		booking2.display();
		HotelBookingSystem booking3 = new HotelBookingSystem(booking2);
        	System.out.println("\nBooking 3 (Copy of Booking 2) Details:");
        	booking3.display();
    	}
}
