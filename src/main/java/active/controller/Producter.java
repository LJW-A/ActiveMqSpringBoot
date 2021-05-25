package active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Queue;

@Controller
//发送端
public class Producter {


    @Autowired
    // 调用Activemq的队列模式
    //  这个是在util里面的 不是官方提供的API
    Queue queue;


    @Autowired
    // 使用这个类 进行一个消息的发送
    JmsMessagingTemplate jmsMessagingTemplate;


    @GetMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(String message){
        //发送消息  直播什么的就是在这去发送
        jmsMessagingTemplate.convertAndSend(queue,message);
        return "发送成功";
    }

}
