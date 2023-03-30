package tfip.paf.day28;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfip.paf.day28.Models.Airbnb;
import tfip.paf.day28.Service.AirbnbService;

@SpringBootApplication
public class Day28Application implements CommandLineRunner {

	@Autowired
	private AirbnbService airbnbSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day28Application.class, args);
	}

	@Override
	public void run(String... args) {
		// Optional<List<Airbnb>> opt = airbnbSvc.getAirbnbByDesc("sea","Brazil");
		// List<Airbnb> results = opt.get();
		// for (Airbnb airbnb : results) {
		// 	System.out.printf("%s\n",airbnb.getName());
		// }
	}

}
