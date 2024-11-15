package sg.edu.nus.iss.vttp5a_day12l.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_day12l.model.Country;

@Repository
public class CountryRepo {
    
    List<Country> countryList;

    public List<Country> getCountries(){
        
        countryList = new ArrayList<>();

        Country country = new Country("SG", "Singapore", 100);
        countryList.add(country);
        country = new Country("MY", "Malaysia", 300);
        countryList.add(country);
        country = new Country("CN", "China", 500);
        countryList.add(country);
        country = new Country("IN", "India", 400);
        countryList.add(country);
        country = new Country("JP", "Japan", 200);
        countryList.add(country);

        return countryList;
    }

    public Boolean createCountry(Country country) {
        if (countryList == null) {
            countryList = new ArrayList<>();
        }

        countryList.add(country);
        return true;
    }

}
