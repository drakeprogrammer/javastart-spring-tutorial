package pl.drakeprogrammer.beans.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static pl.drakeprogrammer.beans.producers.MessageProducerType.ProducerType.SIMPLE_MESSAGE_PRODUCER;

@Component
@MessageProducerType(type = SIMPLE_MESSAGE_PRODUCER)
public class SimpleMessageProducer implements MessageProducer {

	@Autowired
	@Qualifier("randomNumber")
	private int randomNumber;



	@Override
	public String getMessage() {
		return "Example message " + this + " : " + randomNumber;
	}
}
