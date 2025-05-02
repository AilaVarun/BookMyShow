package dev.varun.bookmyshow.models;

import dev.varun.bookmyshow.models.enums.SeatType;
import dev.varun.bookmyshow.models.enums.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String no;
    private SeatType seatType;
    private Screen screen;
}
