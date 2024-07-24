package flight_booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightBookingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App is running...");
	}
}
