package cat.xvcom.redis.client;

import java.util.List;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisClientImpl implements IRedisClient {
	static RedisClient redisClient = null;
	private static StatefulRedisConnection<String, String> redisConnection = null;
	
	
	public StatefulRedisConnection<String, String> getRedisConnection() {
		return redisConnection;
	}

	public void setRedisConnection(StatefulRedisConnection<String, String> redisConnection) {
		this.redisConnection = redisConnection;
	}

	public void put(String pKey, String pValue) throws Exception {
		if (redisConnection!=null) {
			RedisCommands<String, String> syncCommands = redisConnection.sync();

			syncCommands.set(pKey, pValue);
		//	System.out.println("Put "+pKey+"="+pValue);
		}
	}

	/**
	 * Get the value for a especififed key.
	 */
	public String getString(String pKey) throws Exception {
		String ret = null;
		
		if (redisConnection!=null) {
		
			RedisCommands<String, String> syncCommands = redisConnection.sync();
			ret = syncCommands.get(pKey);
			System.out.println("Get "+pKey+" = "+ ret);
		}
		
		return ret;
	}

	/**
	 * Get the value for a specified key and removes the key on redis.
	 * @TODO Is not transactional, needs to be rewrited. XVF
	 */
	public String getStringTx(String pKey) throws Exception {
		String ret = null;
		
		if (redisConnection!=null) {
		
			RedisCommands<String, String> syncCommands = redisConnection.sync();
			ret = syncCommands.get(pKey);
			Long numRemoved = syncCommands.del(pKey);
			System.out.println("Deleted "+pKey+" = "+ret+"("+ numRemoved+")");
		}
		
		return ret;
	}
	
	public void disconnect() throws Exception {
		if (redisConnection!=null) {
			redisConnection.close();
			redisClient.shutdown();
		} else {
			throw new Exception("No active connection found.");
		}

	}

	public void connect(String pServer) throws Exception {
		if (pServer!=null) {
			redisClient = RedisClient.create(pServer);
		    redisConnection = redisClient.connect();
		} else {
			throw new Exception("Redis server cannot be null");
		}
	}
	
	/**
	 * Adds a value to the key by the left.
	 * @param pKey
	 * @param pValue
	 * @throws Exception
	 */
	public void lput(String pKey, String pValue) throws Exception {
		if (redisConnection!=null) {
			RedisCommands<String, String> syncCommands = redisConnection.sync();

			Long numElements = syncCommands.lpush(pKey, pValue);
			System.out.println("LPut "+pKey+"="+pValue+". Num elements:"+numElements);
		}
	}
	
	/**
	 * Obtain all the elements of a list
	 * @param pKey
	 * @return
	 * @throws Exception
	 */
	public List<String> getAll(String pKey) throws Exception {
		List<String> ret = null;
		if (redisConnection!=null) {
			RedisCommands<String, String> syncCommands = redisConnection.sync();

			ret = syncCommands.lrange(pKey, 0, syncCommands.llen(pKey));
		//	System.out.println("LPut "+pKey+"="+pValue+". Num elements:"+numElements);
		}
		
		return ret;
	}

}
