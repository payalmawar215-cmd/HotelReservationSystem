import java.util.Scanner;
public class HotelReservationSystem {
    public static void main(String[] args){
        System.out.println("Welcome to the Hotel Reservation System!");
        Scanner sc = new Scanner(System.in);
        boolean[] rooms=new boolean[10];
        for(int i=0;i<rooms.length;i++){
            rooms[i]=true;
        }
        String[] bookingDetails=new String[10];

        while(true){
        System.out.println("===== HOTEL RESERVATION SYSTEM =====\n1. View Available Rooms\n" + "2. Book a Room\n" + "3. View Booking Details\n" + "4. Cancel Reservation\n" + "5. Exit");
         
        System.out.print("Please select an option (1-5): ");
        if(!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            sc.next();  
            continue;  
        }

        int choice = sc.nextInt();
        
        System.out.println("Your selected option: " + choice);
        switch (choice) {
            case 1:
                System.out.println("Viewing available rooms...");
                int availableRoomsCount = 0;
                for(int i=0;i<10;i++){
                    if(rooms[i]){
                        System.out.println("Room " + (i+1) + " is available.");
                        availableRoomsCount++;
                    } else {
                        System.out.println("Room " + (i+1) + " is booked.");
                    }
                }
                System.out.println("Total available rooms: " + availableRoomsCount);
                break;
            case 2:
                System.out.println("Booking a room...");
                System.out.print("Enter room number to book (1-10): ");
                if(!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                    sc.next();  
                    continue;  
                }
                int roomNumber = sc.nextInt();
                if(roomNumber < 1 || roomNumber > 10){
                    System.out.println("Invalid room number. Please select a number between 1 and 10.");
                } else if(!rooms[roomNumber - 1]){
                    System.out.println("Room " + roomNumber + " is already booked. Please select another room.");
                } else {
                    String customerName;
                    System.out.print("Enter your name: ");
                    sc.nextLine(); // Consume the newline character
                    customerName = sc.nextLine(); 
                    if(customerName.trim().isEmpty()){
                        System.out.println("Name cannot be empty. Booking cancelled.");
                        break;
                    }  
                    rooms[roomNumber - 1] = false;
                    bookingDetails[roomNumber - 1] = customerName;
                    System.out.println("Room " + roomNumber + " has been successfully booked.");
                }
                break;
            case 3:
                System.out.println("Viewing booking details...");
                int bookedRoomsCount = 0;
                boolean anyBooked = false;
                for(int i=0;i<10;i++){
                    if(bookingDetails[i] != null){
                        System.out.println("Room " + (i+1) + " is booked by " + bookingDetails[i] + ".");
                        bookedRoomsCount++;
                        anyBooked = true;
                    }
                    
                }
                if(!anyBooked){
                    System.out.println("No rooms are currently booked.");
                } else {
                    System.out.println("Total booked rooms: " + bookedRoomsCount);
                }
                break;
            case 4:
                System.out.println("Cancelling reservation...");
                System.out.print("Enter room number to cancel (1-10): ");
                if(!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 1 and 10.");
                    sc.next();  
                    continue;  
                }
                int cancelRoomNumber = sc.nextInt();
                if(cancelRoomNumber < 1 || cancelRoomNumber > 10){
                    System.out.println("Invalid room number. Please select a number between 1 and 10.");
                } else if(rooms[cancelRoomNumber - 1]){
                    System.out.println("Room " + cancelRoomNumber + " is not booked. Cannot cancel reservation.");
                } else {
                    rooms[cancelRoomNumber - 1] = true;
                    bookingDetails[cancelRoomNumber - 1] = null;
                    System.out.println("Reservation for Room " + cancelRoomNumber + " has been successfully cancelled.");
                }

                break;
            case 5:
                System.out.println("Exiting the system. Thank you!");
                 
                return;
            default:
                System.out.println("Invalid option selected. Please try again.");
        }
    }
    }
}
