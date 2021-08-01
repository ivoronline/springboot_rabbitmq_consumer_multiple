package com.ivoronline.springboot_rabbitmq_consumer_multiple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "Queue1")
public class Consumer {

  @Autowired Environment environment;

  @RabbitHandler
  public void receiver(String message) {
    String port = environment.getProperty("server.port");
    System.out.println(port + " Received Message: " + message);
  }

}


