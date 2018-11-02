package cat.xvcom.redis.client;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRedisClient {
	
	private static IRedisClient rc = null;

	@Before
	public void setUp() throws Exception {
		rc = new RedisClientImpl();
		rc.connect("redis://localhost:6379/0");
		assert(rc!=null);
		
	}

	@After
	public void tearDown() throws Exception {
		if (rc!=null) {
			rc.disconnect();
		}
	}

	@Test
	public void test00() {
		assert (rc!=null);
	}
	
	@Test
	public void test01Put() {
		String svalue = "VAL";
		
		if (rc!=null) {
			try {
				rc.put("testKey", svalue);
			} catch (Exception e) {
				fail(e.getMessage());
			}
		} else {
			fail("no connection");
		}
	}

	@Test
	public void test02Get() {
		String svalue = "VAL";
		
		if (rc!=null) {
			try {
				String v = rc.getString("testKey");
				assert(svalue.equals(v));
			} catch (Exception e) {
				fail(e.getMessage());
			}
		} else {
			fail("no connection");
		}
	}
	
	@Test
	public void test03PutMassive() {
		String svalue = "VAL";
		
		if (rc!=null) {
			try {
				for(int i=0;i<5000;i++) {
					rc.put("testKey"+i, svalue+""+i);
				}
			} catch (Exception e) {
				fail(e.getMessage());
			}
		} else {
			fail("no connection");
		}
	}
	
	
}
