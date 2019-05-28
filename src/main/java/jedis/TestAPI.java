package jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("k1", "k1");
        jedis.set("k2", "k2");
        jedis.set("k3", "k3");
        String k1 = jedis.get("k1");
        String k2 = jedis.get("k2");
        String k3 = jedis.get("k3");
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        Set<String> keys = jedis.keys("*");
        for (String key :
                keys) {
            System.out.println(key+"--"+jedis.get(key));
        }
    }
}
