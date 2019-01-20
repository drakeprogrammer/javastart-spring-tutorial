package pl.drakeprogrammer.beans.producers;

import org.springframework.stereotype.Component;

import static pl.drakeprogrammer.beans.producers.MessageProducerType.ProducerType.SIMPLE_MESSAGE_PRODUCER;

@Component
@MessageProducerType(type = SIMPLE_MESSAGE_PRODUCER)
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Example message " + System.currentTimeMillis();
	}
}
