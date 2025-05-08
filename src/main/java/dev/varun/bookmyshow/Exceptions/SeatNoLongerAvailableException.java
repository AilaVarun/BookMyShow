package dev.varun.bookmyshow.Exceptions;

public class SeatNoLongerAvailableException extends RuntimeException{
    public SeatNoLongerAvailableException(String message) {
        super(message);
    }
}
