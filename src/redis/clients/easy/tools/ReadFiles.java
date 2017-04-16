package redis.clients.easy.tools;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import redis.clients.easy.manager.PoolsStaticData;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Read configuration file of redis pool
 * 
 * @author xiaodou.Yu
 *
 */
public class ReadFiles extends PoolsStaticData {
	
	/**
	 * read and init the maps of jedisPool
	 * 
	 * @param url
	 * @param maps
	 * @return
	 */
	public void readXmlFile(String url,Map<String,JedisPool> maps){
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder db;
			
			db = dbf.newDocumentBuilder();
			
			Document doc = db.parse(url);
			
			NodeList dogList = doc.getElementsByTagName("pool");  
			
			for(int node=0;node<dogList.getLength();node++){
				
				Node pool = dogList.item(node); 
				
                Element elem = (Element) pool; 
                
                String poolName=elem.getAttribute("name");
                
                if(maps.containsKey(poolName)){
                	
                	throw new ThisSuchExecption("have a same name in poolMaps!");
                	
                }else{
                	
                	JedisPoolConfig config = new JedisPoolConfig();
                	
                	String host=null;
                	
                	Integer port=null;
                	
                	for(Node cnode = pool.getFirstChild(); cnode != null; cnode = cnode.getNextSibling()){
                		
                		if (cnode.getNodeType() == Node.ELEMENT_NODE){  
                           
                			String name = cnode.getNodeName();  
                            
                			String value = cnode.getFirstChild().getNodeValue();  
                            
                			
                			if(HOST.equals(name)||name==HOST){
                            	
                				host=value;
                           
                			}
                			
                			if(PORT.equals(name)||name==PORT){
                            	
                				port=Integer.valueOf(value);
                           
                			}
                			
                			if(MAX_TOTAL.equals(name)||name==MAX_TOTAL){
                            	
                				config.setMaxTotal(Integer.valueOf(value));
                           
                			}
                			
                			if(MAX_IDLE.equals(name)||name==MAX_IDLE){
                				
                				config.setMaxIdle(Integer.valueOf(value));
                				
                			}
                			
                			if(MIN_IDLE.equals(name)||name==MIN_IDLE){
                				
                				config.setMinIdle(Integer.valueOf(value));
                				
                			}
                			
                			if(TEST_ON_BORROW.equals(name)||name==TEST_ON_BORROW){
                				
                				config.setTestOnBorrow(Boolean.valueOf(value));
                				
                			}
                			
                			if(TEST_ON_RETURN.equals(name)||name==TEST_ON_RETURN){
                				
                				config.setTestOnReturn(Boolean.valueOf(value));
                				
                			}
                			
                			if(MAX_WAIT_MILLIS.equals(name)||name==MAX_WAIT_MILLIS){
                				
                				config.setMaxWaitMillis(Long.valueOf(value));
                				
                			}
                			
                			if(TBERM.equals(name)||name==TBERM){
                				
                				config.setTimeBetweenEvictionRunsMillis(Long.valueOf(value));
                				
                			}
                			
                			if(TEST_WHILE_IDLE.equals(name)||name==TEST_WHILE_IDLE){
                				
                				config.setTestWhileIdle(Boolean.valueOf(value));
                				
                			}
                			
                			if(TEST_ON_CREATE.equals(name)||name==TEST_ON_CREATE){
                				
                				config.setTestOnCreate(Boolean.valueOf(value));
                				
                			}
                			
                			if(SOFT_MIN_ETITM.equals(name)||name==SOFT_MIN_ETITM){
                				
                				config.setSoftMinEvictableIdleTimeMillis(Long.valueOf(value));
                				
                			}
                			
                			if(NUM_TPER.equals(name)||name==NUM_TPER){
                				
                				config.setNumTestsPerEvictionRun(Integer.valueOf(value));
                				
                			}
                			
                			if(MIN_ETITM.equals(name)||name==MIN_ETITM){
                				
                				config.setMinEvictableIdleTimeMillis(Long.valueOf(value));
                				
                			}
                			
                			if(LIFO.equals(name)||name==LIFO){
                				
                				config.setLifo(Boolean.valueOf(value));
                				
                			}
                			
                			if(JMX_NPF.equals(name)||name==JMX_NPF){
                				
                				config.setJmxNamePrefix(value);
                				
                			}
                			
                			if(JMX_NB.equals(name)||name==JMX_NB){
                				
                				config.setJmxNameBase(value);
                				
                			}
                			
                			if(BLOCK_WETD.equals(name)||name==BLOCK_WETD){
                				
                				config.setBlockWhenExhausted(Boolean.valueOf(value));
                				
                			}
                			
                			if(EPCN.equals(name)||name==EPCN){
                				
                				config.setEvictionPolicyClassName(value);
                				
                			}
                			
                			if(FAIR_NESS.equals(name)||name==FAIR_NESS){
                				
                				config.setFairness(Boolean.valueOf(value));
                				
                			}
                			
                			if(JMX_ENABLED.equals(name)||name==JMX_ENABLED){
                				
                				config.setJmxEnabled(Boolean.valueOf(value));
                				
                			}
                			
                        } 
                		
                	}
                	
                	JedisPool jp=new JedisPool(config,host,port);
                	
                	maps.put(poolName, jp);
                	
                }
				
			}
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
		
	}
	
}
