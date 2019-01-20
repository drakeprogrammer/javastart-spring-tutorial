package pl.drakeprogrammer.beans.decorators;

import org.springframework.stereotype.Component;

import static pl.drakeprogrammer.beans.decorators.MessageDecoratorType.DecoratorType.UPPER_CASE_MESSAGE_DECORATOR;

@Component
@MessageDecoratorType(type = UPPER_CASE_MESSAGE_DECORATOR)
public class UpperCaseMessageDecorator implements MessageDecorator {
	@Override
	public String decorate(String message) {
		return message.toUpperCase();
	}
}
