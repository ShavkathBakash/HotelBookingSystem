public class Hotel {

    private int hotelId;
    private String hotelName;
    private String location;
    private double pricePerNight;

    // Default Constructor
    public Hotel() {
    }

    // Constructor with Hotel ID
    public Hotel(int hotelId, String hotelName, String location, double pricePerNight) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    // Constructor without Hotel ID
    public Hotel(String hotelName, String location, double pricePerNight) {
        this.hotelName = hotelName;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    // Getters
    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    // Setters
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Display Hotel Details
    @Override
    public String toString() {
        return String.format(
                "%-8d %-25s %-20s Rs. %.2f",
                hotelId,
                hotelName,
                location,
                pricePerNight);
    }
}