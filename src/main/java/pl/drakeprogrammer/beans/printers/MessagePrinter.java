package pl.drakeprogrammer.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.drakeprogrammer.beans.producers.MessageProducer;
import pl.drakeprogrammer.beans.decorators.MessageDecorator;

@Component
public class MessagePrinter {

	private MessageProducer messageProducer;
	private MessageDecorator messageDecorator;

	@Autowired
	public MessagePrinter(@Qualifier("fileMessageProducer") MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	/**
	 * When @Component annotation will be remove from UpperCaseMessageDecorator then class won't be injected.
	 * We should use injecting by setter only when we want to use dependency as optional (in fact and reality NEVER do this)!
	 *
	 * @param messageDecorator
	 */
	@Autowired(required = false)
	public void setMessageDecorator(@Qualifier("lowerCaseMessageDecorator") MessageDecorator messageDecorator) {
		this.messageDecorator = messageDecorator;
	}

	public void print() {
		String message = messageProducer.getMessage();
		message = (messageDecorator != null) ? messageDecorator.decorate(message) : message;
		System.out.println(message);
	}
}
