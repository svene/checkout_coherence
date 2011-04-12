package org.svenehrke.checkout.coherence;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

public class Contact implements PortableObject {

	private String firstName;
	private String lastName;
	private Address homeAddress;
	private Address workAddress;
	private Map telephoneNumbers;
	private java.sql.Date birthDate;

	public Contact() {
	}

	public Contact(String aFirstName, String aLastName, Address aHomeAddress, Address aWorkAddress, Map aTelephoneNumbers, Date aBirthDate) {
		firstName = aFirstName;
		lastName = aLastName;
		homeAddress = aHomeAddress;
		workAddress = aWorkAddress;
		telephoneNumbers = aTelephoneNumbers;
		birthDate = aBirthDate;
	}

	public void readExternal(PofReader aPofReader) throws IOException {
		setFirstName(aPofReader.readString(0));
		setLastName(aPofReader.readString(1));
		setHomeAddress((Address) aPofReader.readObject(2));
		setWorkAddress((Address) aPofReader.readObject(3));
		setTelephoneNumbers(aPofReader.readMap(4, null));
		setBirthDate(new Date(aPofReader.readLong(5)));
	}

	public void writeExternal(PofWriter aPofWriter) throws IOException {
		aPofWriter.writeString(0, getFirstName());
		aPofWriter.writeString(1, getLastName());
		aPofWriter.writeObject(2, getHomeAddress());
		aPofWriter.writeObject(3, getWorkAddress());
		aPofWriter.writeMap(4, getTelephoneNumbers());
		aPofWriter.writeLong(5, getBirthDate().getTime());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String aFirstName) {
		firstName = aFirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String aLastName) {
		lastName = aLastName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address aHomeAddress) {
		homeAddress = aHomeAddress;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address aWorkAddress) {
		workAddress = aWorkAddress;
	}

	public Map getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void setTelephoneNumbers(Map aTelephoneNumbers) {
		telephoneNumbers = aTelephoneNumbers;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date aBirthDate) {
		birthDate = aBirthDate;
	}


	public int getAge() {
		return (int) ((System.currentTimeMillis() - birthDate.getTime()) / MILLIS_IN_YEAR);
	}

	/**
		* Approximate number of millis in a year ignoring things such as leap
		* years. Suitable for example use only.
		*/
		public static final long MILLIS_IN_YEAR = 1000L * 60L * 60L * 24L * 365L;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Contact contact = (Contact) o;

		if (birthDate != null ? !birthDate.equals(contact.birthDate) : contact.birthDate != null) return false;
		if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
		if (homeAddress != null ? !homeAddress.equals(contact.homeAddress) : contact.homeAddress != null) return false;
		if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
		if (telephoneNumbers != null ? !telephoneNumbers.equals(contact.telephoneNumbers) : contact.telephoneNumbers != null)
			return false;
		if (workAddress != null ? !workAddress.equals(contact.workAddress) : contact.workAddress != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
		result = 31 * result + (workAddress != null ? workAddress.hashCode() : 0);
		result = 31 * result + (telephoneNumbers != null ? telephoneNumbers.hashCode() : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Contact{" +
			"firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", homeAddress=" + homeAddress +
			", workAddress=" + workAddress +
			", telephoneNumbers=" + telephoneNumbers +
			", birthDate=" + birthDate +
			'}';
	}
}
