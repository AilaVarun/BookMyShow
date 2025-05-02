package dev.varun.bookmyshow.models;

import dev.varun.bookmyshow.models.enums.PaymentMode;
import dev.varun.bookmyshow.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private String transactionId;
    private String amount;
    private PaymentStatus status;
    private PaymentMode paymentMode;
}
