package jedis;

import redis.clients.jedis.Jedis;

public class TestMS {
    public static void main(String[] args) {
        Jedis jedis_m = new Jedis("127.0.0.1", 6379);
        Jedis jedis_s = new Jedis("127.0.0.1", 6380);
        jedis_s.slaveof("127.0.0.1", 6379);
        jedis_m.set("m", "m");
        String m = jedis_s.get("m");
        System.out.println(m);
    }
}
