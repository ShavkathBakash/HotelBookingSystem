import java.sql.*;

public class BookingDAO {

    // ==============================
    // Add Booking
    // ==============================
    public void addBooking(Booking booking) {

        String query = "INSERT INTO booking(customer_name, hotel_id, nights) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, booking.getCustomerName());
            ps.setInt(2, booking.getHotelId());
            ps.setInt(3, booking.getNights());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\n Booking Added Successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // View Bookings
    // ==============================
    public void viewBookings() {

        String query = "SELECT * FROM booking";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("\n====================================================================");
            System.out.printf("%-10s %-25s %-10s %-10s%n",
                    "ID", "CUSTOMER NAME", "HOTEL ID", "NIGHTS");
            System.out.println("====================================================================");

            while (rs.next()) {

                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getString("customer_name"),
                        rs.getInt("hotel_id"),
                        rs.getInt("nights"));

                System.out.println(booking);
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // Search Booking
    // ==============================
    public void searchBooking(int bookingId) {

        String query = "SELECT * FROM booking WHERE booking_id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, bookingId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getString("customer_name"),
                        rs.getInt("hotel_id"),
                        rs.getInt("nights"));

                System.out.println("\nBooking Found");
                System.out.println("-----------------------------------------");
                System.out.println(booking);

            } else {

                System.out.println("\nBooking Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // Cancel Booking
    // ==============================
    public void cancelBooking(int bookingId) {

        String query = "DELETE FROM booking WHERE booking_id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, bookingId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nBooking Cancelled Successfully.");
            } else {
                System.out.println("\nBooking ID Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}