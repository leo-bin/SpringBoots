package bins.springboot.redis.common.mq.producer;

import bins.springboot.redis.common.mq.Message;

/**
 * @author leo-bin
 * @date 2020/6/15 16:00
 * @apiNote 生产者基类
 */
public interface BaseProducer {

    void produce(Message message);
}
