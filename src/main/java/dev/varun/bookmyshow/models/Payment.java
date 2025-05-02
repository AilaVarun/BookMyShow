package dev.varun.bookmyshow.models;

import dev.varun.bookmyshow.models.enums.PaymentMode;
import dev.varun.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String transactionId;
    private Long amount;
    @Enumerated
    private PaymentStatus status;
    @Enumerated
    private PaymentMode paymentMode;
}
