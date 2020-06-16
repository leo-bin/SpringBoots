package bins.springboot.redis.core.service;

import bins.springboot.redis.RedisApplicationTests;
import bins.springboot.redis.common.mq.consumer.TestConsumer;
import bins.springboot.redis.common.mq.producer.TestProducer;
import bins.springboot.redis.common.util.RedisUtil;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


class TestRedisQueueServiceTest extends RedisApplicationTests {

    @Resource
    private TestProducer producer;
    @Resource
    private TestConsumer consumer;
    @Resource
    private RedisUtil redisUtil;


    @Test
    public void testRedisQueue() {
        //开启生产者线程
        producer.start();

        //开启消费者线程
        consumer.start();

        //主线程需要挂在这里等待其他线程结束
        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testPoll() {
        String key = "poll test";
        redisUtil.lPush(key, "test data");
        System.out.println(redisUtil.bRPop(key, 500L, TimeUnit.MILLISECONDS));
    }
}