package org.svenehrke.checkout.coherence;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

import java.io.IOException;

public class Address implements PortableObject {
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;

	/**
	 * Default constructor (necessary for PortableObject implementation).
	 */
	public Address() {
	}

	public Address(String aStreet1, String aStreet2, String aCity, String aState, String aZip, String aCountry) {
		street1 = aStreet1;
		street2 = aStreet2;
		city = aCity;
		state = aState;
		zip = aZip;
		country = aCountry;
	}

	public void readExternal(PofReader aPofReader) throws IOException {
		setStreet1(aPofReader.readString(0));
		setStreet2(aPofReader.readString(1));
		setCity(aPofReader.readString(2));
		setState(aPofReader.readString(3));
		setZip(aPofReader.readString(4));
		setCountry(aPofReader.readString(5));
	}

	public void writeExternal(PofWriter aPofWriter) throws IOException {
		aPofWriter.writeString(0, getStreet1());
		aPofWriter.writeString(1, getStreet2());
		aPofWriter.writeString(2, getCity());
		aPofWriter.writeString(3, getState());
		aPofWriter.writeString(4, getZip());
		aPofWriter.writeString(5, getCountry());
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String aStreet1) {
		street1 = aStreet1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String aStreet2) {
		street2 = aStreet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String aCity) {
		city = aCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String aState) {
		state = aState;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String aZip) {
		zip = aZip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String aCountry) {
		country = aCountry;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if (city != null ? !city.equals(address.city) : address.city != null) return false;
		if (country != null ? !country.equals(address.country) : address.country != null) return false;
		if (state != null ? !state.equals(address.state) : address.state != null) return false;
		if (street1 != null ? !street1.equals(address.street1) : address.street1 != null) return false;
		if (street2 != null ? !street2.equals(address.street2) : address.street2 != null) return false;
		if (zip != null ? !zip.equals(address.zip) : address.zip != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = street1 != null ? street1.hashCode() : 0;
		result = 31 * result + (street2 != null ? street2.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (state != null ? state.hashCode() : 0);
		result = 31 * result + (zip != null ? zip.hashCode() : 0);
		result = 31 * result + (country != null ? country.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Address{" +
			"street1='" + street1 + '\'' +
			", street2='" + street2 + '\'' +
			", city='" + city + '\'' +
			", state='" + state + '\'' +
			", zip='" + zip + '\'' +
			", country='" + country + '\'' +
			'}';
	}
}
