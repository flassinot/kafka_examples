package com.example.testkafka.workers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = WorkerApplication.class)
@EmbeddedKafka(partitions = 3, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092",
    "auto.create.topics.enable=true"})
@ActiveProfiles("test")
class WorkerApplicationTest {

  @Autowired
  public KafkaTemplate<String, Work> template;

  @BeforeEach
  void setup() {
    System.out.println(template);
  }

  @Test
  public void test_work() throws InterruptedException {
    System.out.println("Sending tasks to workers...");

    // Different keys should send messages to different partitions
    template.send("work", "partitionA", new Work(5D));
    template.send("work", "partitionB", new Work(10D));
    template.send("work", "partitionC", new Work(15D));
    template.send("work", "partitionA", new Work(20D));
    template.send("work", "partitionB", new Work(25D));
    template.send("work", "partitionC", new Work(30D));

    Thread.sleep(30000);
  }
}
