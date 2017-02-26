package redis.clients.easy.manager;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * offers init pools get a pool,distroy a pool and 
 * get a jedis stance
 * 
 * @author xiaodou.Yu
 *
 */
public class PoolManager {
	
	public  PoolManager(){
		
	}
	
	/**
	 * get a object of JedisPool
	 * 
	 * @param name
	 * @return JedisPool
	 */
	public  JedisPool getPool(String name){
		
		Map<String,JedisPool> maps =PoolsStaticData.getMaps();
				
		if(maps.containsKey(name)){
			
			return maps.get(name);
			
		}else{
			
			return null;
			
		}
		
	}
	
	public  Jedis getJedis(JedisPool jp){

		Jedis jedis  = null;  
	        
	    int count =0;  
	     
	    do{  
	        	
	        try{   
	            	
	            jedis = jp.getResource();  
	                
	            } catch (Exception e) {  
	            	
	            	System.out.println("get redis master1 failed!");  
	            	
	            	jedis.close();
	            	
	            }  
	            
	            count++;  
	            
	        }while(jedis==null&&count<10);  
	        
	        return jedis;  
	}
	
}
