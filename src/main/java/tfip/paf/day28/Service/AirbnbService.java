package tfip.paf.day28.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.paf.day28.Models.Airbnb;
import tfip.paf.day28.Repositories.AirbnbRepository;

@Service
public class AirbnbService {
    
    @Autowired
    private AirbnbRepository airbnbRepo;

    public Optional<List<Airbnb>> getAirbnbByDesc (String text) {
        List<Airbnb> results = airbnbRepo.getAirbnbByDesc(text);
		if (results.isEmpty())
			return Optional.empty();
		// return the first result
		return Optional.of(results);
    }

}
