package cat.xvcom.redis.client;

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

	public String getString(String pKey) throws Exception {
		String ret = null;
		
		if (redisConnection!=null) {
		
			RedisCommands<String, String> syncCommands = redisConnection.sync();
			ret = syncCommands.get(pKey);
			System.out.println("Get "+pKey+" = "+ ret);
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

}
