package sg.edu.nus.iss.vttp5a_day12l.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;
import sg.edu.nus.iss.vttp5a_day12l.service.CountryService;


@Controller
@RequestMapping("/countries")
public class CountryController {
    
    @Autowired
    CountryService countryService;

    // Test if linking is working
    // @ResponseBody
    // @GetMapping("")
    // public List<Country> getCountries(){
    //     return countryService.getCountries();
    // }


    @GetMapping("")
    public String getCountries(Model model) {

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        return "countrylist";
    }


    @GetMapping("/filter")
    public String filterCountries(@RequestParam(name = "population") String population, Model model) {
        
        List<Country> countries = countryService.getCountries();
        List<Country> filteredCountries = countries.stream()
                                            .filter(c -> c.getPopulation() >= Integer.parseInt(population))
                                            .collect(Collectors.toList());
        
        model.addAttribute("countries", filteredCountries);

        return "countrylist";
    }
    
}
