package active.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//接收端
public class CommUser {

    //队列
    //使用的是Java的jms监听器在检测队列消息是否发过来
    //destination = "java-a" 就是类接收这个队列   使用的是一个名字来接受队列
    @JmsListener(destination = "java-a")
    //从这个队列里面取出数据  ActiveMq默认的是一个先进后出的原则 将这个对立而放到另一个容器里面 先进的放在最底下 后进的放在最上面
    //java-a(1,2,3,4,5,6)     java-b(6,5,4,3,2,1)
    @SendTo("java-b")
    @ResponseBody
    public String  getmessage(String message){
        System.out.println(message);
        return "发送成功";
    }
}
