package com.example.testkafka.broadcast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class BCConsumer1 {

  private final Logger logger = LoggerFactory.getLogger(BCConsumer1.class);

  @KafkaListener(topics = "temp", groupId = "mobile1Group")
  public void listen(Double temp) throws InterruptedException {
    logger.info("Mobile 1 received " + temp + "°");
    Thread.sleep(1000);
  }

}