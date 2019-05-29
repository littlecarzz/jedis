###### String类型:
set key value   //插入字符串

get key //查找value

getset key value    //查找返回value并赋值

mset key1 value1 key2 vlaue2 key3 value3   //多键值对数据保存，在保证原子性操作下

mget key1 key2  //查找多个value

setnx key value //表示当一个指定的 key 不存在时，设置这个 key 指定的 value，如果存在，则设置不成功

setex key time(s) value //设置key/value的有效期

msetnx key1 value1 key2 value2 key3 value3
//表示在单原子操作性的情况下，keys 不存在的前提下插入多个 values 值，如果存在其中一个keys 则插入失败

incr key //表示对给定 key 的 value 进行递增的操作

incrby key 5    //表示对给定 key 的 value 进行指定步长的递增操作

decr key    //表示对给定 key 的 value 进行递减的操作

decrby key 5    //表示对给定 key 的 value 进行指定步长的递减操作

append key value //追加，key不存在则新建

substr key 0 4  //表示返回指定 key 的 value 的部分字符串

list类型：
lpush key c b a        //从左向右插入cba
rpush james c b a     //从右向左插入cba, 返回值3
linsert james before b teacher //在b之前插入teacher, after为之后
lpop james         //把最左边的第一个元素c删除
rpop james        //把最右边的元素a删除
lrange key start end   //索引下标特点：从左到右为0到N-1
lrange james 0 -1     //从左到右获取列表所有元素 返回 c b a
lindex james -1      //返回最右末尾a，-2返回b
llen james          //返回当前列表长度
lrem key num value //表示删除指定 key 的 list 里面值为 value 的指定个数
set类型：
exists user          //检查user键值是否存在
sadd user a b c     //向user插入3个元素，返回3
sadd user a b      //若再加入相同的元素，则重复无效，返回0
smembers user     //获取user的所有元素,返回结果无序
srem user a      //返回1，删除a元素
scard user     //返回2，计算元素个数
smove set1 set2 value //将value从set1移动到set2
sismember set value //判断是否存在
sinter set1 set2 //进行交集操作，并返回相同的成员
sinterstore set1 set2 set3 //set2和set3执行交集操作，存到set1
sunion //并集操作
sunionstore //并集操作，存在指定的set
sdiff //两个set进行对比，返回不同的成员
sdiffstore //两个set进行对比，不同的成员存到指定set
srandmember //返回随机一个成员
zset类型：(排序后set集合)
添加元素
zadd key score member [score member......]
zadd user:zan 200 james                    //james的点赞数1, 返回操作成功的条数1
zadd user:zan 200 james 120 mike 100 lee  // 返回3
zadd test:1 nx 100 james                 //键test:1必须不存在，主用于添加
zadd test:1 xx incr 200 james           //键test:1必须存在，主用于修改,此时为300
zadd test:1 xx ch incr -299 james      //返回操作结果1，300-299=1
查看元素
zscore user:zan james                //查看分数
zrange user:zan 0 -1 withscores     //查看索引0~-1全部元素，并带上分数与成员名
zrevrange user:zan 0 400           //展示分值在0-400之间的元素，降序james,mike..
zrangebyscore user:zan 0 400      //展示分值在0-400之间的元素，升序lee,mike..
zrevrangebyscore user:zan 400 10 //展示分值在400-10之间的元素，降序james,mike..
查看名次
zrank user:zan james                 //查看名次：第3名返回2，从0开始到2，共3名
zrevrank user:zan james             //反排序，返回0，点赞数越高，排名越前
增加分数
zincrby user:zan 100 james         //在200的基础上加100
删除元素
zrem user:zan james               //删除元素james
zremrangebyrank user:zan 0 1     //删除索引0-1的元素
zremrangebyscore user:zan 0 100 //删除分数0-100之间的元素
统计元素
zcard user:zan                 //计算成员个数，返回3
zcount user:zan 0 400         //计算分数0-400之间的元素个数，返回3
hash类型：
设值
hset user:1 name james    //成功返回1，失败返回0
取值
hget user:1 name         //返回james
删值
hdel user:1 age         //返回删除的个数
计算个数
hset user:1 name james
hset user:1 age 23
hlen user:1            //返回2，user:1有两个属性值
批量设值
hmset user:2 name james age 23 sex boy //返回OK
批量取值
hmget user:2 name age sex   //返回三行：james 23 boy
判断field是否存在
hexists user:2 name        //若存在返回1，不存在返回0
获取所有field
hkeys user:2              // 返回name age sex三个field
获取user:2所有value
hvals user:2             // 返回james 23 boy
获取user:2所有field与value
hgetall user:2          //name age sex james 23 boy值
数量增加
hincrby user:2 age 1         //age+1
hincrbyfloat user:2 age 2   //浮点型加2









