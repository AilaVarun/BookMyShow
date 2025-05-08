package dev.varun.bookmyshow.Controllers;

import dev.varun.bookmyshow.Models.Booking;
import dev.varun.bookmyshow.Models.enums.ResponseStatus;
import dev.varun.bookmyshow.Services.BookingService;
import dev.varun.bookmyshow.dtos.BookingRequestDTO;
import dev.varun.bookmyshow.dtos.BookingResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/book")
    public BookingResponseDTO bookTicket(@RequestBody BookingRequestDTO bookingRequestDTO){

        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try{
            Booking booking = bookingService.bookticket(bookingRequestDTO.getUserId(),
                    bookingRequestDTO.getShowSeatIds(),
                    bookingRequestDTO.getShowId());
            bookingResponseDTO.setTicket(booking);
            bookingResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch(Exception e){
            bookingResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookingResponseDTO;
    }

}
