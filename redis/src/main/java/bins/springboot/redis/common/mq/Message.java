package bins.springboot.redis.common.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leo-bin
 * @date 2020/6/15 15:39
 * @apiNote 消息实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    /**
     * 消息id
     */
    private String msgId;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 额外传递的数据
     */
    private String data;
}
