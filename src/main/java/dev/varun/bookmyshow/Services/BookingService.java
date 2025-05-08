package dev.varun.bookmyshow.Services;

import dev.varun.bookmyshow.Exceptions.SeatNoLongerAvailableException;
import dev.varun.bookmyshow.Exceptions.ShowNotFoundException;
import dev.varun.bookmyshow.Exceptions.ShowSeatNotFoundException;
import dev.varun.bookmyshow.Exceptions.UserNotFoundException;
import dev.varun.bookmyshow.Models.Booking;
import dev.varun.bookmyshow.Models.Show;
import dev.varun.bookmyshow.Models.ShowSeat;
import dev.varun.bookmyshow.Models.User;
import dev.varun.bookmyshow.Models.enums.BookingStatus;
import dev.varun.bookmyshow.Models.enums.ShowSeatStatus;
import dev.varun.bookmyshow.repositories.ShowRepository;
import dev.varun.bookmyshow.repositories.ShowSeatRepository;
import dev.varun.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculationService priceCalculationService;
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = new PriceCalculationService();
    }
    public Booking bookticket(Long userId,
                              List<Long> showSeatIds,
                              Long showId){

        Optional<User> OptionalUser=userRepository.findById(userId);
        if(OptionalUser.isEmpty()){
            throw new UserNotFoundException(userId+" User not found");
        }
        User user=OptionalUser.get();


        Optional<Show> OptionalShow=showRepository.findById(showId);
        if(OptionalShow.isEmpty()){
            throw new ShowNotFoundException(showId+" Show not found");
        }
        Show show=OptionalShow.get();


        List<ShowSeat> showSeats=showSeatRepository.findAllByShowSeatAndLock(showSeatIds);
        if(showSeats.size()!=showSeatIds.size()){
            throw new ShowSeatNotFoundException("All ShowSeats not found");
        }

        for(ShowSeat showSeat:showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNoLongerAvailableException(showSeats+" Show Seats are not available");
            }
        }

        Booking booking = new Booking();
        // as of now booking status is pending, once payment is confirmed,
        // booking status will be changed to confirmed
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setBookingId("Booking_"+userId+"show_"+showId);
        booking.setUser(user);
        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
        }
        showSeatRepository.saveAll(showSeats);
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculationService.CalculatePrice(showSeats));


        booking.setBookingStatus(BookingStatus.CONFIRMED);

        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
        }
        showSeatRepository.saveAll(showSeats);




        return booking;

    }

}
