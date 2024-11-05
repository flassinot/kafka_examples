package com.example.testkafka.workers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class WorkerConsumer3 {

  private final Logger logger = LoggerFactory.getLogger(WorkerConsumer3.class);

  @Autowired
  ComputeService computeService;

  @KafkaListener(topics = "work", groupId = "workers")
  public void listen(ConsumerRecord<String, Work> record) throws InterruptedException {
    logger.info("Worker 3 received: " + record.value() + " on Partition " + record.partition());
    logger.info("Worker 3 result in Fahrenheit: " + computeService.convertToFahrenheit(
        record.value() != null && record.value().getTemp() != null ? record.value().getTemp() : 0D));
    Thread.sleep(1000);
  }
}
