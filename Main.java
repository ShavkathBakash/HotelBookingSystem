import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                HotelDAO hotelDAO = new HotelDAO();
                BookingDAO bookingDAO = new BookingDAO();

                while (true) {

                        System.out.println("\n========================================");
                        System.out.println("       HOTEL BOOKING SYSTEM");
                        System.out.println("========================================");
                        System.out.println("1. Add Hotel");
                        System.out.println("2. View Hotels");
                        System.out.println("3. Search Hotel");
                        System.out.println("4. Update Hotel");
                        System.out.println("5. Delete Hotel");
                        System.out.println("----------------------------------------");
                        System.out.println("6. Add Booking");
                        System.out.println("7. View Bookings");
                        System.out.println("8. Search Booking");
                        System.out.println("9. Cancel Booking");
                        System.out.println("----------------------------------------");
                        System.out.println("0. Exit");
                        System.out.println("========================================");

                        System.out.print("Enter your choice : ");

                        int choice = sc.nextInt();
                        sc.nextLine();

                        switch (choice) {

                                case 1:

                                        System.out.println("\n----- Add Hotel -----");

                                        System.out.print("Hotel Name : ");
                                        String hotelName = sc.nextLine();

                                        System.out.print("Location : ");
                                        String location = sc.nextLine();

                                        System.out.print("Price Per Night : ");
                                        double price = sc.nextDouble();
                                        sc.nextLine();

                                        Hotel hotel = new Hotel(
                                                        hotelName,
                                                        location,
                                                        price);

                                        hotelDAO.addHotel(hotel);

                                        break;

                                case 2:

                                        hotelDAO.viewHotels();

                                        break;

                                case 3:

                                        System.out.print("\nEnter Hotel ID : ");
                                        int searchId = sc.nextInt();
                                        sc.nextLine();

                                        hotelDAO.searchHotel(searchId);

                                        break;

                                case 4:

                                        System.out.print("\nEnter Hotel ID : ");
                                        int updateId = sc.nextInt();
                                        sc.nextLine();

                                        System.out.print("New Hotel Name : ");
                                        String newName = sc.nextLine();

                                        System.out.print("New Location : ");
                                        String newLocation = sc.nextLine();

                                        System.out.print("New Price : ");
                                        double newPrice = sc.nextDouble();
                                        sc.nextLine();

                                        hotelDAO.updateHotel(
                                                        updateId,
                                                        newName,
                                                        newLocation,
                                                        newPrice);

                                        break;

                                case 5:

                                        System.out.print("\nEnter Hotel ID : ");

                                        int deleteId = sc.nextInt();
                                        sc.nextLine();

                                        hotelDAO.deleteHotel(deleteId);

                                        break;
                                case 6:
                                        System.out.println("\n----- Add Booking -----");

                                        System.out.print("Customer Name : ");
                                        String customerName = sc.nextLine();

                                        System.out.print("Hotel ID : ");
                                        int hotelId = sc.nextInt();

                                        System.out.print("Number of Nights : ");
                                        int nights = sc.nextInt();
                                        sc.nextLine();

                                        Booking booking = new Booking(
                                                        customerName,
                                                        hotelId,
                                                        nights);

                                        bookingDAO.addBooking(booking);

                                        break;

                                case 7:

                                        bookingDAO.viewBookings();

                                        break;

                                case 8:

                                        System.out.print("\nEnter Booking ID : ");
                                        int bookingSearchId = sc.nextInt();
                                        sc.nextLine();

                                        bookingDAO.searchBooking(bookingSearchId);

                                        break;

                                case 9:

                                        System.out.print("\nEnter Booking ID to Cancel : ");
                                        int cancelId = sc.nextInt();
                                        sc.nextLine();

                                        bookingDAO.cancelBooking(cancelId);

                                        break;

                                case 0:

                                        System.out.println("\n========================================");
                                        System.out.println("Thank you for using Hotel Booking System.");
                                        System.out.println("========================================");

                                        sc.close();
                                        System.exit(0);

                                        break;

                                default:

                                        System.out.println("\nInvalid Choice! Please try again.");

                        }

                }

        }

}