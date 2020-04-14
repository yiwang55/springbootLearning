package com.atguigu.amqp.service;

import com.atguigu.amqp.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @RabbitListener(queues = "atguigu.news")
    public void received(Book book){
        System.out.println(book);
    }
}
