package pl.drakeprogrammer.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.drakeprogrammer.beans.MessagePrinter;
import pl.drakeprogrammer.beans.MessageProducer;
import pl.drakeprogrammer.beans.SimpleMessageProducer;

@Configuration
public class ApplicationConfig {

	@Bean
	public MessagePrinter getMessagePrinter() {
		MessageProducer messageProducer = new SimpleMessageProducer();
		return new MessagePrinter(messageProducer);
	}
}
