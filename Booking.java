public class Booking {

    private int bookingId;
    private String customerName;
    private int hotelId;
    private int nights;

    // Default Constructor
    public Booking() {
    }

    // Constructor with Booking ID
    public Booking(int bookingId, String customerName, int hotelId, int nights) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.hotelId = hotelId;
        this.nights = nights;
    }

    // Constructor without Booking ID
    public Booking(String customerName, int hotelId, int nights) {
        this.customerName = customerName;
        this.hotelId = hotelId;
        this.nights = nights;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getNights() {
        return nights;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    // Display Booking Details
    @Override
    public String toString() {
        return String.format(
                "%-10d %-25s %-10d %-10d",
                bookingId,
                customerName,
                hotelId,
                nights);
    }
}