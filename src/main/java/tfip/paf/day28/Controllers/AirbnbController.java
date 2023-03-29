package tfip.paf.day28.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tfip.paf.day28.Models.Airbnb;
import tfip.paf.day28.Service.AirbnbService;

@Controller
@RequestMapping
public class AirbnbController {
    
    @Autowired
    private AirbnbService airbnbSvc;

    @GetMapping(path="/search")
    public String showAirbnb(@RequestParam String keyword, Model model) {
        Optional<List<Airbnb>> opt = airbnbSvc.getAirbnbByDesc(keyword);
        if (opt.isEmpty()) {
            model.addAttribute("message", "No Airbnb with keyword '%s' inside its description".formatted(keyword));
            return "notFound";
        }
        model.addAttribute("airbnbList",opt.get());
        return "details";
    }

}
