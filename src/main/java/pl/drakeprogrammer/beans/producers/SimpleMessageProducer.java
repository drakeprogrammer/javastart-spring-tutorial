package pl.drakeprogrammer.beans.producers;

import org.springframework.stereotype.Component;

@Component
@SimpleMessage
public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Example message " + System.currentTimeMillis();
	}
}
