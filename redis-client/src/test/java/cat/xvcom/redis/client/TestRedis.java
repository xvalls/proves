package cat.xvcom.redis.client;

import java.util.List;

import cat.xvcom.utils.ConsoleUtils;

public class TestRedis {
	public static final String SERVER = "redis://localhost:6379/0";
	IRedisClient rc = null;
	
	public TestRedis() {
		rc = new RedisClientImpl();
	}
	
	public void optionConnect() {
		if (rc!=null) {
			try {
				rc.connect(TestRedis.SERVER);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void optionDisconnect() {
		if (rc!=null)
			try {
				rc.disconnect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void optionPutString() {
		if (rc!=null) {
			
			String k = ConsoleUtils.readString("Key");
			String v = ConsoleUtils.readString("Value");
			try {
				rc.put(k, v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void optionGetKey() {
		if (rc!=null) {
			String k = ConsoleUtils.readString("Key");
			try {
				String v = rc.getString(k);
				System.out.println("key value = "+v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void optionLPut() {
		if (rc!=null) {
			
			String k = ConsoleUtils.readString("Key");
			String v = ConsoleUtils.readString("Value");
			try {
				rc.lput(k, v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void optionLGetRange() {
		if (rc!=null) {
			String k = ConsoleUtils.readString("Key");
			try {
				List<String> v = rc.getAll(k);
				if (v!=null) {
					for(int i=0;i<v.size();i++) {
						System.out.println("value["+i+"] = "+v.get(i));
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void menu () {
		int option = -1;

		do {
			System.out.println("Redis Client Commands");
			System.out.println("-----------------------------");
			System.out.println("1-Connect");
			System.out.println("2-Disconnect");
			System.out.println("3-Put String");
			System.out.println("4-Get key");
			System.out.println("5-lput String");
			System.out.println("6-get all elementes of range");
			System.out.println();
			
			option = ConsoleUtils.readInt("What is your choice (select 0 to exit)");
		
			switch (option) {
			
				case 1 : optionConnect();
						 break;
				case 2 : optionDisconnect();
					     break;
				case 3 : optionPutString();
						 break;
				case 4 : optionGetKey();
				         break;
				case 5 : optionLPut();
						 break;
				case 6 : optionLGetRange();
		         		 break;
						
			}
			
			
		
		} while (option!=0);
	}
	
	

	
	public static void main(String[] args) {
		
		
		TestRedis trc = new TestRedis();
		trc.menu();
		

	}

}
