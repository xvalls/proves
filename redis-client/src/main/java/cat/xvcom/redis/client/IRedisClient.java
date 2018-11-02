package cat.xvcom.redis.client;

public interface IRedisClient {

	
	
	public void put(String pKey, String pValue) throws Exception;
	
	public String getString(String pKey) throws Exception;
	
	public void disconnect() throws Exception;
	
	public void connect(String pServer) throws Exception;
}
