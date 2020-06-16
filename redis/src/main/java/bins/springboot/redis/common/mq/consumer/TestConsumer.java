package bins.springboot.redis.common.mq.consumer;

import bins.springboot.redis.common.mq.Message;
import bins.springboot.redis.common.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static bins.springboot.redis.common.constant.RedisQueueConstant.TEST_QUEUE_KEY;

/**
 * @author leo-bin
 * @date 2020/6/15 17:31
 * @apiNote
 */
@Slf4j
@Component
public class TestConsumer extends Thread implements BaseConsumer {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }


    @Override
    public void consume() {
        Message message = (Message) redisUtil.bRPop(TEST_QUEUE_KEY, 500L, TimeUnit.MILLISECONDS);
        if (message != null) {
            log.info("正在处理消息：消息id：{}，消息内容：{}", message.getMsgId(), message.getMessage());
        }
    }
}
