package tfip.paf.day28.Models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Airbnb {

    private String name;
    private String url;
    private String summary;
    private String description;
    private String country;
    
    public Airbnb() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    
    public static Airbnb toAirbnb(String jsonStr) {
        Airbnb airbnb = new Airbnb();
		JsonReader reader = Json.createReader(new StringReader(jsonStr));
		JsonObject o = reader.readObject();
		airbnb.setName(o.getString("name"));
        airbnb.setUrl(o.getString("listing_url"));
        airbnb.setSummary(o.getString("summary"));
        airbnb.setDescription(o.getString("description"));
        JsonObject jo = o.getJsonObject("address");
        airbnb.setCountry(jo.getString("country"));
		return airbnb;
    }

    
}
