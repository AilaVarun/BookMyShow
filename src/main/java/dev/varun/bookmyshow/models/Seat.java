package dev.varun.bookmyshow.Models;

import dev.varun.bookmyshow.Models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String no;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    @ManyToOne
    private Screen screen;
}
