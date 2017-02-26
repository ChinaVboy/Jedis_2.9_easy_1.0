package redis.clients.easy.manager;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.JedisPool;

/**
 * Information about the configuration file of a pool
 * 
 * needed to store in a static form
 * 
 * @author xiaodou.Yu
 *
 */
public class PoolsStaticData {

	public final String MAX_TOTAL="maxTotal";
	
	public final String MAX_IDLE="maxIdle";
	
	public final String MIN_IDLE="minIdle";
	
	public final String TEST_ON_CREATE="testOnCreate";
	
	public final String TEST_ON_BORROW="testOnBorrow";
	
	public final String TEST_ON_RETURN="testOnReturn";
	
	public final String TEST_WHILE_IDLE="testWhileIdle";
	
	public final String MAX_WAIT_MILLIS="maxWaitMillis";
	
	public final String FAIR_NESS="fairness";
	
	public final String MIN_ETITM="minEvictableIdleTimeMillis";
	
	public final String SOFT_MIN_ETITM="softMinEvictableIdleTimeMillis";
	
	public final String NUM_TPER="numTestsPerEvictionRun";
	
	public final String EPCN="evictionPolicyClassName";
	
	public final String TBERM="timeBetweenEvictionRunsMillis";
	
	public final String BLOCK_WETD="blockWhenExhausted";
	
	public final String JMX_ENABLED="jmxEnabled";
	
	public final String JMX_NPF="jmxNamePrefix";
	
	public final String JMX_NB="jmxNameBase";
	
	public final String LIFO="lifo";
	
	public final String HOST="host";
	
	public final String PORT="port";
	
	/**
	 * key:every jedisPool must have name ,and get the 
	 * jedidPool by name
	 * value:the object of jedisPool
	 * When trying to configure files, put all the
	 * jedispool configuration information in maps
	 * 
	 */
	private static Map<String,JedisPool> easyJedisMaps  = new HashMap<String,JedisPool>();
	
	public synchronized static  Map<String,JedisPool> getMaps(){
		
		return easyJedisMaps;
		
	}

}
