package si.rso.kafka.services;

public interface KafkaService {
    
    void produceMessage(String topic, Object message);
    
}
