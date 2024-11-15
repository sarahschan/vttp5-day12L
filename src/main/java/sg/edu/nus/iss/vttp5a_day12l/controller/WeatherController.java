package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_day12l.service.CountryService;


@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    CountryService countryService;
    

    @GetMapping("")
    public String weather(@RequestParam(required = true, name = "city", defaultValue = "Singapore") String city,
                          @RequestParam(name="units", defaultValue = "metrics") String units,
                           Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", units);

        return "weather";
    }


    // Using path variable
    @GetMapping("/city/{city}/units/{units}")
    public String weather2(@PathVariable(required = true, name = "city") String city,
                           @PathVariable(name="units") String units,
                           Model model) {

        model.addAttribute("city", city);
        model.addAttribute("units", units);

        return "weather";
    }


    //
    @GetMapping("/pagea")
    public String pageA(Model model){
        String[] units = {"millimeters", "centimeters", "meters", "kilometers"};
        List<Country> countries = countryService.getCountries();

        model.addAttribute("countries", countries);
        model.addAttribute("units", units);

        return "pagea";
    }



    @GetMapping("/forma")
    public String showForm(){
        return "forma";
    }

    @PostMapping("/forma")
    public String handleFormA(@RequestBody MultiValueMap<String, String> form){
        
        // Map<String, String> formData = new HashMap<>();
        
        for (String s : form.keySet()) {
            // formData.put(s, form.getFirst(city));
            System.out.println(s + ">>>" + form.getFirst(s));
        }
        

        return "forma";        
    }

}
