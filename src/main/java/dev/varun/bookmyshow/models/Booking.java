package dev.varun.bookmyshow.models;

import dev.varun.bookmyshow.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel {
    private String bookingId;
    private BookingStatus bookingStatus;
    private List<Payment> payments;
    private List<ShowSeat> showSeats;
    private User user;
    private Long amount;
}
