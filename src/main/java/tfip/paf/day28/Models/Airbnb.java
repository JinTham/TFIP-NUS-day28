package tfip.paf.day28.Models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Airbnb {

    private Integer id;
    private String name;
    private String summary;
    private String description;
    
    public Airbnb() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    public static Airbnb toAirbnb(String jsonStr) {
        Airbnb airbnb = new Airbnb();
		JsonReader reader = Json.createReader(new StringReader(jsonStr));
		JsonObject o = reader.readObject();
		airbnb.setName(o.getString("name"));
		airbnb.setId(o.getInt("id"));
        airbnb.setSummary(o.getString("summary"));
        airbnb.setDescription(o.getString("description"));
		return airbnb;
    }
    
}
