class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head;
    
    public TicketReservationSystem() {
        this.head = null;
    }
    
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // circular reference
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // circular reference
        }
    }
    
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        
        TicketNode temp = head;
        TicketNode prev = null;
        
        do {
            if (temp.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    // If the head node is to be removed
                    if (temp.next == head) {
                        head = null; // List becomes empty
                    } else {
                        head = temp.next;
                        TicketNode last = head;
                        while (last.next != temp) {
                            last = last.next;
                        }
                        last.next = head; // Adjust circular reference
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("Ticket with ID " + ticketId + " not found.");
    }
    
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicketByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("No tickets found for customer " + customerName);
        }
    }

    public void searchTicketByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        
        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                                   ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        
        if (!found) {
            System.out.println("No tickets found for movie " + movieName);
        }
    }
    
    public int countTickets() {
        if (head == null) {
            return 0;
        }
        
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        
        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "Alice", "Inception", "A1", "2025-02-11 18:00");
        system.addTicket(2, "Bob", "Interstellar", "B2", "2025-02-11 19:00");
        system.addTicket(3, "Charlie", "Inception", "C3", "2025-02-11 20:00");

        system.displayTickets();
        
        system.removeTicket(2);
        
        system.displayTickets();
        
        system.searchTicketByCustomerName("Alice");
        system.searchTicketByMovieName("Inception");
        
        System.out.println("Total tickets booked: " + system.countTickets());
    }
}
