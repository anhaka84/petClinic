package Entities;

import DB.main.DB;
import Models.BookingModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingEntity {

    private final DB<BookingModel> db = new DB<>();

    private String query;
    private List condition;
    private final String columns = "("
            + "service_id,"
            + "user_id,"
            + "pet_id,"
            + "booking_date,"
            + "booking_time,"
            + "update_date,"
            + "price"
            + ")";

    public boolean addBooking(BookingModel booking) {
        query = "INSERT INTO Booking " + columns
                + " VALUES (?,?,?,?,?,?,?)";
        condition = Arrays.asList(
                booking.getServiceId(),
                booking.getUserId(),
                booking.getPetId(),
                booking.getBookingDate(),
                booking.getBookingTime(),
                booking.getUpdateDate(),
                booking.getPrice()
        );
        return db.setSqlDataRow(query, condition, booking);
    }

    public BookingModel getOneBooking(int bookingId) {
        query = "SELECT * FROM Booking WHERE booking_id = ?";
        condition = Arrays.asList(bookingId);
        return db.getOne(query, condition, new BookingModel());
    }

    public ArrayList<BookingModel> getAllBooking() {
        query = "SELECT * FROM Booking";
        return db.getAll(query, new BookingModel());
    }

    public boolean updateBooking(BookingModel booking) {
        query = "UPDATE Booking SET "
                + "booking_date = ?,"
                + "booking_time = ?,"
                + "update_date = ?"
                + " WHERE booking_id = ?";
        condition = Arrays.asList(
                booking.getBookingDate(),
                booking.getBookingTime(),
                booking.getUpdateDate(),
                booking.getBookingId()
        );
        return db.setSqlDataRow(query, condition, booking);
    }

    public boolean deleteBooking(int bookingId) {
        query = "DELETE FROM Booking WHERE booking_id = ?";
        condition = Arrays.asList(bookingId);
        return db.setSqlDataRow(query, condition, new BookingModel());
    }
}
