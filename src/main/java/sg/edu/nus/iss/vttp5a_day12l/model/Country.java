package sg.edu.nus.iss.vttp5a_day12l.model;

public class Country {
    
    private String code;
    private String name;
    private Integer population;
    
    
    public Country() {
    }
    
    public Country(String code, String name, Integer population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPopulation() {
        return population;
    }
    public void setPopulation(Integer population) {
        this.population = population;
    }


    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + ", population=" + population + "]";
    }

}
