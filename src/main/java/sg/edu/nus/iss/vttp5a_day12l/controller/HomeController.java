package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")        // To come into this controller: http://localhost:8080/home
public class HomeController {

    // returns home page
    @GetMapping("")             // http://localhost:8080/home/
    public String home(Model model) {
        // getting the time
        model.addAttribute("currTime", (new Date()).toString());
        
        // getting the hour of the day
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));
        
        return "home";
    }


}
