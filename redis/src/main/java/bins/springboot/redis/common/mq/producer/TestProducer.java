package bins.springboot.redis.common.mq.producer;

import bins.springboot.redis.common.mq.Message;
import bins.springboot.redis.common.util.CommonUtil;
import bins.springboot.redis.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static bins.springboot.redis.common.constant.RedisQueueConstant.TEST_QUEUE_KEY;

/**
 * @author leo-bin
 * @date 2020/6/15 17:20
 * @apiNote
 */
@Slf4j
@Component
public class TestProducer extends Thread implements BaseProducer {

    @Resource
    private RedisUtil redisUtil;


    @Override
    public void run() {
        while (true) {
            produce(new Message(CommonUtil.UUID32(), "test消息", ""));
        }
    }


    @Override
    public void produce(Message message) {
        if (message != null) {
            redisUtil.lPush(TEST_QUEUE_KEY, message);
            log.info("生产者线程：" + Thread.currentThread().getName() + "正在产生消息：消息id：{}，消息内容：{}", message.getMsgId(), message.getMessage());
        }
    }
}
