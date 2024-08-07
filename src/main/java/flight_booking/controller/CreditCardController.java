package flight_booking.controller;

import flight_booking.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stripe.model.Charge;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/charge")
    public Charge chargeCard(@RequestHeader(value = "token") String token, @RequestHeader(value = "amount") Double amount) throws Exception {
        return creditCardService.chargeNewCard(token, amount);
    }
}
