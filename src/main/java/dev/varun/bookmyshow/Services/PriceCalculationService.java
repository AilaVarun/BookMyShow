package dev.varun.bookmyshow.Services;

import dev.varun.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculationService {


    public Long CalculatePrice(List<ShowSeat> showSeats){


        long price = 0L;
        for(ShowSeat showSeat:showSeats){
            price += showSeat.getPrice();
        }
        return price;
    }
}
