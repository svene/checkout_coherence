package org.svenehrke.checkout.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Before running this test, first start server with script '$COHERENCE_HOME/bin/cache-server
public class Test02Cluster {

	static final String NAME = "Sven Ehrke";
	static final String KEY = "Name";

	@BeforeClass
	public static void init() {
		System.setProperty("tangosol.coherence.distributed.localstorage", "false");

	}

	@Test
	public void test1() {
		CacheFactory.ensureCluster();
		NamedCache myCache = CacheFactory.getCache("mycache");
//		myCache.put(KEY, NAME);// comment out on second run
		assertEquals(NAME, myCache.get(KEY));

		CacheFactory.shutdown();
	}

}
