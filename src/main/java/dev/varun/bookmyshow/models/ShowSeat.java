package dev.varun.bookmyshow.models;

import dev.varun.bookmyshow.models.enums.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private Long price;
    private ShowSeatStatus showSeatStatus;
}
