package si.rso.kafka.services.impl;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.streaming.common.annotations.StreamProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import si.rso.event.streaming.JacksonMapper;
import si.rso.kafka.services.KafkaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaServiceImpl implements KafkaService {
    
    private static final Logger LOG = LogManager.getLogger(KafkaServiceImpl.class.getName());
    
    @Inject
    @StreamProducer
    private Producer<String, String> producer;
    
    @Override
    public void produceMessage(String topic, Object message) {
        String stringifiedMessage = JacksonMapper.stringify(message);
    
        ProducerRecord<String, String> record = new ProducerRecord<>(
            topic,
            "key",
            stringifiedMessage
        );
    
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {
                exception.printStackTrace();
            }
        });
    }
}
