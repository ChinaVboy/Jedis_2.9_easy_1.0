package redis.clients.easy.manager;

import java.util.Map;

import redis.clients.easy.tools.ReadFiles;
import redis.clients.jedis.JedisPool;

/**
 * Pool initialization tool ,Construction method
 * need a path to the configuration file,a url
 * 
 * @author xiaodou.Yu
 *
 */
public class PoolsInitializer {
	
	public PoolsInitializer(String url){
		
		initPools(url);
		
	}
	
	
	/**
	 * Instantiate  configuration information from configuration file
	 * 
	 * into static variable jediseasymap
	 * 
	 * @param url
	 */
	private void initPools(String url){
		
		Map<String,JedisPool> maps =PoolsStaticData.getMaps();
       
		ReadFiles rf=new ReadFiles();
		
		rf.readXmlFile(url, maps);
		
	}

}
