package Models;

import java.util.Map;

public class PlacesModel {

	private String post_code;
	private String country;
	private String country_Abb;
	private Map<String, String> places;
	
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_Abb() {
		return country_Abb;
	}
	public void setCountry_Abb(String country_Abb) {
		this.country_Abb = country_Abb;
	}
	public Map<String, String> getPlaces() {
		return places;
	}
	public void setPlaces(Map<String, String> places) {
		this.places = places;
	}
}
