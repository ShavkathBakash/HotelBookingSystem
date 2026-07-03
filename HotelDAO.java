import java.sql.*;

public class HotelDAO {

    // ==============================
    // Add Hotel
    // ==============================
    public void addHotel(Hotel hotel) {

        String query = "INSERT INTO hotel(hotel_name, location, price_per_night) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getLocation());
            ps.setDouble(3, hotel.getPricePerNight());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\n Hotel Added Successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // View Hotels
    // ==============================
    public void viewHotels() {

        String query = "SELECT * FROM hotel";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {

            System.out.println("\n==============================================================");
            System.out.printf("%-8s %-25s .%-20s %-12s%n",
                    "ID", "HOTEL NAME", "LOCATION", "PRICE");
            System.out.println("==============================================================");

            while (rs.next()) {

                Hotel hotel = new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getString("location"),
                        rs.getDouble("price_per_night"));

                System.out.println(hotel);
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // Search Hotel
    // ==============================
    public void searchHotel(int hotelId) {

        String query = "SELECT * FROM hotel WHERE hotel_id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, hotelId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Hotel hotel = new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getString("hotel_name"),
                        rs.getString("location"),
                        rs.getDouble("price_per_night"));

                System.out.println("\nHotel Found");
                System.out.println("----------------------------------------------");
                System.out.println(hotel);

            } else {

                System.out.println("\nNo Hotel Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // Update Hotel
    // ==============================
    public void updateHotel(int hotelId,
            String hotelName,
            String location,
            double price) {

        String query = "UPDATE hotel SET hotel_name=?, location=?, price_per_night=? WHERE hotel_id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, hotelName);
            ps.setString(2, location);
            ps.setDouble(3, price);
            ps.setInt(4, hotelId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nHotel Updated Successfully.");
            } else {
                System.out.println("\nHotel ID Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    // ==============================
    // Delete Hotel
    // ==============================
    public void deleteHotel(int hotelId) {

        String query = "DELETE FROM hotel WHERE hotel_id=?";

        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, hotelId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nHotel Deleted Successfully.");
            } else {
                System.out.println("\nHotel ID Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}