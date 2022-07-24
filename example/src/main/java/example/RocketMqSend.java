package example;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class RocketMqSend {
    public static void main(String[] args) throws Exception{
        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("myProduct-group");
        // 指定Nameserver地址
        producer.setNamesrvAddr("192.168.190.130:9876");
        // 启动生产者
        producer.start();
        // 创建消息对象，指定主题、标签和消息体
        Message msg = new Message("myTopic", "myTag", ("RocketMq message").getBytes());
        // 发送消息
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        // 关闭生产者
        producer.shutdown();
    }
}
