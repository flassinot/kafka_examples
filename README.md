# Two Kafka use cases

These examples show two use cases for using Kafka.

## Broadcast or Publisher/Subscriber using one partition

The BroadcastTempApplicationTest test class creates a Kafka server and sends messages on one partition to be read
by 3 consumers (mobiles and desktop PCs). Each consumer receives the same message.

## Sending tasks to workers using three partitions

WorkerApplicationTest sends messages containing temperatures with different keys to a topic on 3 partitions.
Consumers (workers) read the temps and convert them, each reading from one partition because of the different keys
used to send the messages.
