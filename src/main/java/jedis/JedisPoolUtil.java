package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static volatile JedisPool jedisPool=null;
    public JedisPoolUtil(){}
    public static  JedisPool getJedisPoolInstance(){
        if(null==jedisPool){
            synchronized (JedisPoolUtil.class){
                if(null==jedisPool){
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxIdle(32);
                    jedisPoolConfig.setMaxWaitMillis(1000*1000);
                    jedisPoolConfig.setMaxTotal(10);
                    jedisPoolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
                }
            }
        }
        return jedisPool;
    }
    public static void release(Jedis jedis){
        if(null!=jedis){
            jedis.close();
        }
    }
}
