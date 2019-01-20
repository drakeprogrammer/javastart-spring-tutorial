package pl.drakeprogrammer.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.drakeprogrammer.beans.decorators.MessageDecorator;
import pl.drakeprogrammer.beans.decorators.MessageDecoratorType;
import pl.drakeprogrammer.beans.producers.MessageProducer;
import pl.drakeprogrammer.beans.producers.MessageProducerType;

import static pl.drakeprogrammer.beans.decorators.MessageDecoratorType.DecoratorType.LOWER_CASE_MESSAGE_DECORATOR;
import static pl.drakeprogrammer.beans.decorators.MessageDecoratorType.DecoratorType.UPPER_CASE_MESSAGE_DECORATOR;
import static pl.drakeprogrammer.beans.producers.MessageProducerType.ProducerType.FILE_MESSAGE_PRODUCER;

@Component
public class MessagePrinter {

	private MessageProducer messageProducer;
	private MessageDecorator messageDecorator;

	@Autowired
	public MessagePrinter(@MessageProducerType(type = FILE_MESSAGE_PRODUCER) MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	/**
	 * When @Component annotation will be remove from UpperCaseMessageDecorator then class won't be injected.
	 * We should use injecting by setter only when we want to use dependency as optional (in fact and reality NEVER do this)!
	 *
	 * @param messageDecorator
	 */
	@Autowired(required = false)
	public void setMessageDecorator(
			@MessageDecoratorType(type = UPPER_CASE_MESSAGE_DECORATOR) MessageDecorator messageDecorator) {
		this.messageDecorator = messageDecorator;
	}

	public void print() {
		String message = messageProducer.getMessage();
		message = (messageDecorator != null) ? messageDecorator.decorate(message) : message;
		System.out.println(message);
	}
}
