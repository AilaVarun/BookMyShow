package dev.varun.bookmyshow.dtos;

import dev.varun.bookmyshow.Models.Booking;
import dev.varun.bookmyshow.Models.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDTO {
    private Booking ticket;
    private ResponseStatus responseStatus;


}
