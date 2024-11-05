package com.example.testkafka.broadcast;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = BroadcastTempApplication.class)
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092",
    "auto.create.topics.enable=true"})
@ActiveProfiles("test")
class BroadcastTempApplicationTest {

  @Autowired
  public KafkaTemplate<String, Double> template;

  @BeforeEach
  void setup() {
  }

  @Test
  public void test_broadcast() throws InterruptedException {
    System.out.println("Sending temperatures to devices...");
    template.send("temp", 5D);
    template.send("temp", 10D);
    template.send("temp", 15D);

    Thread.sleep(30000);
  }
}
