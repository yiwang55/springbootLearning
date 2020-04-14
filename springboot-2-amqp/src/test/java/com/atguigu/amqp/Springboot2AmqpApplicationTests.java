package com.atguigu.amqp;

import com.atguigu.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot2AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    void contextLoads() {
//        MessageProperties messageProperties = new MessageProperties();
//        Message message = new Message("hello spring rabbitmq".getBytes(), messageProperties);
//        rabbitTemplate.send("exchange.direct","atguigu",message);

//        Map<String, Object> map = new HashMap<>();
//        map.put("msg","first msg");
//        map.put("data", Arrays.asList("heello", 123, true));
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news", map);

            rabbitTemplate.convertAndSend("exchange.direct","atguigu.news", new Book("围城","钱钟书"));
    }

    @Test
    void received(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    void amqpAdminTest(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));

//        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
//        System.out.println("创建成功！");

        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE, "amqpAdmin.exchange", "amqp.haha", null));
    }

}
