package flight_booking.dto;


import flight_booking.domain.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private long id;
    private long userId;
    private double billValue;
    private String cardNumber;
    private String cardHolder;
    private String expiryDate;
    private String cvc;
    private Payment paymentType;
    private boolean paymentStatus;
}
