package org.svenehrke.checkout.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ContactTest {

	@BeforeClass
	public static void init() {
		System.setProperty("tangosol.coherence.distributed.localstorage", "false");
		System.setProperty("tangosol.coherence.cacheconfig", "contacts-cache-config.xml");
		System.setProperty("tangosol.pof.config", "contacts-pof-config.xml");

//		System.setProperty("tangosol.coherence.clusterport", "9001");
//		System.setProperty("tangosol.coherence.wka", "localhost");
	}

	@Test
	public void testContact() {
		CacheFactory.ensureCluster();

		NamedCache contact = CacheFactory.getCache("contact");

		Contact con1 = createAndStoreContact(contact);
		Contact con2 = (Contact) contact.get(con1.getFirstName());
		assertEquals(con2.getFirstName(), con1.getFirstName());

		CacheFactory.shutdown();
	}

	private Contact createAndStoreContact(NamedCache aContact) {
		Address homeAddress = new Address("4157 Wash Ave", "Suite 4", "Burlingame", "CA", "94407", "USA");
		Address workAddress = new Address("500 Oracle Pkwy", "MS989", "Redwood Shores", "CA", "94065", "USA");
		Date date = new Date(2009, 04, 01);
		PhoneNumber phonenumber = new PhoneNumber((short) 11, (short) 650, (short) 506, 7000);
		Map map = new HashMap();
		map.put("home", phonenumber);

		Contact con1 = new Contact("Tom", "Dunn", homeAddress, workAddress, map, date);

		aContact.put("1", homeAddress);
		aContact.put(con1.getFirstName(), con1);
		return con1;
	}
}

