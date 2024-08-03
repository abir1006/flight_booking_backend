package flight_booking.service.Impl;

import flight_booking.domain.Payment;
import flight_booking.dto.PaymentDto;
import flight_booking.repositories.PaymentRepository;
import flight_booking.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl extends GenericServiceImpl<Payment, Long, PaymentDto> implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        super(paymentRepository, modelMapper, Payment.class, PaymentDto.class);
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean confirmBooking(Long bookingId) {
        //  payment confirmation logic here
        // third-party payment gateway API

        return true;
    }


    @Override
    public PaymentDto save(PaymentDto paymentDto) {
        return null;
    }

    @Override
    public List<PaymentDto> findAll() {
        return List.of();
    }

    @Override
    public Optional<PaymentDto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public PaymentDto update(Long aLong, PaymentDto paymentDto) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }



}
