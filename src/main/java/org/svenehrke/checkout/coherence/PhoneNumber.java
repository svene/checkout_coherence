package org.svenehrke.checkout.coherence;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

import java.io.IOException;

public class PhoneNumber implements PortableObject {

	private short accessCode;
	private short countryCode;
	private short areaCode;
	private int localNumber;

	public PhoneNumber() {
	}

	public PhoneNumber(short aAccessCode, short aCountryCode, short aAreaCode, int aLocalNumber) {
		accessCode = aAccessCode;
		countryCode = aCountryCode;
		areaCode = aAreaCode;
		localNumber = aLocalNumber;
	}

	public void readExternal(PofReader aPofReader) throws IOException {
		setAccessCode(aPofReader.readShort(0));
		setCountryCode(aPofReader.readShort(1));
		setAreaCode(aPofReader.readShort(2));
		setLocalNumber(aPofReader.readInt(3));
	}

	public void writeExternal(PofWriter aPofWriter) throws IOException {
		aPofWriter.writeShort(0, getAccessCode());
		aPofWriter.writeShort(1, getCountryCode());
		aPofWriter.writeShort(2, getAreaCode());
		aPofWriter.writeInt(3, getLocalNumber());
	}

	public short getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(short aAccessCode) {
		accessCode = aAccessCode;
	}

	public short getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(short aCountryCode) {
		countryCode = aCountryCode;
	}

	public short getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(short aAreaCode) {
		areaCode = aAreaCode;
	}

	public int getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(int aLocalNumber) {
		localNumber = aLocalNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PhoneNumber that = (PhoneNumber) o;

		if (accessCode != that.accessCode) return false;
		if (areaCode != that.areaCode) return false;
		if (countryCode != that.countryCode) return false;
		if (localNumber != that.localNumber) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) accessCode;
		result = 31 * result + (int) countryCode;
		result = 31 * result + (int) areaCode;
		result = 31 * result + localNumber;
		return result;
	}

	@Override
	public String toString() {
		return "PhoneNumber{" +
			"accessCode=" + accessCode +
			", countryCode=" + countryCode +
			", areaCode=" + areaCode +
			", localNumber=" + localNumber +
			'}';
	}
}
