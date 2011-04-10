package org.svenehrke.checkout.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {

	static final String NAME = "Sven Ehrke";
	static final String KEY = "Name";

	@Test
	public void test1() {
		NamedCache myCache = CacheFactory.getCache("mycache");
		myCache.put(KEY, NAME);
		assertEquals(NAME, myCache.get(KEY));
	}

}
