package at.fh.swenga.jpa.model;

import javax.persistence.Embeddable;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;


@Embeddable
public class Address {
	
	private String street;
	private String city;
	private String country;
	private int zip;
	
	public Address() {
	}
	
	public Address(String street, String city, String country, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

//	public void sanitize() {
//		this.street=Jsoup.clean(this.street,Whitelist.simpleText());
//		this.country=Jsoup.clean(this.country,Whitelist.simpleText());
//		this.city=Jsoup.clean(this.city,Whitelist.simpleText());
//	}


	
	
}
