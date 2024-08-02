package flight_booking.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;
    private double billValue;
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvc;
    private PaymentType paymentType;
    private boolean paymentStatus;


    enum PaymentType{
        PAYPAL, CREDIT_CARD;
    }



}
