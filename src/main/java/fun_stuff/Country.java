package fun_stuff;

public class Country implements Comparable<Country>, Cloneable {
    private String name;
    private String continent;
    private int population;

    private String capital;

    private  String pic;
    private String  lat;
    private  String lon;
    private String sub;
    private String area;


    public Country() {
        this("Unknown", "Unknown", 0,"Unknown","Unknown", "0", "0","Unknown","0");
    }

    public Country(String name, String continent, int population,String pic,String capital,String lon,String lat,String sub,String area) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.pic = pic;
        this.capital = capital;
        this.lat = lat;
        this.lon = lon;
        this.sub = sub;
        this.area = area;
    }
    public  String getLon(){return lon;}
    public String getLat(){return lat;}
    public String getArea(){return area;}
    public  String getSub(){return sub;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPic() {return pic;}
    public  String getCap(){return  capital;}


    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
