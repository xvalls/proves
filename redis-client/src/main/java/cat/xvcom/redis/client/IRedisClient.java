package cat.xvcom.redis.client;

import java.util.List;

public interface IRedisClient {

	
	/**
	 * Put a pair key-value on a redis server.
	 * @param pKey
	 * @param pValue
	 * @throws Exception
	 */
	public void put(String pKey, String pValue) throws Exception;
	
	/**
	 * Get the value of the specified key
	 * @param pKey
	 * @return
	 * @throws Exception
	 */
	public String getString(String pKey) throws Exception;
	
	/**
	 * Adds a value to the key by the left.
	 * @param pKey
	 * @param pValue
	 * @throws Exception
	 */
	public void lput(String pKey, String pValue) throws Exception;
	
	/**
	 * Obtain all the elements of a list
	 * @param pKey
	 * @return
	 * @throws Exception
	 */
	public List<String> getAll(String pKey) throws Exception;
	
	/**
	 * Disconnect from the active redis server.
	 * @throws Exception
	 */
	public void disconnect() throws Exception;
	
	/**
	 * Connect to a specified redis server.
	 * @param pServer
	 * @throws Exception
	 */
	public void connect(String pServer) throws Exception;
}
