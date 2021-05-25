package active.util;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

//单例 饿汉式的 标注
@Configuration
public class ActiveQueue {

    @Bean
    //@Bean注入容器
    //创建一个对象 ActiveMQQueue 将这个对象放入容器里面  java-a 就是它在队列里面的名字
   public Queue queue(){
       return new ActiveMQQueue("java-a");
   }
}
