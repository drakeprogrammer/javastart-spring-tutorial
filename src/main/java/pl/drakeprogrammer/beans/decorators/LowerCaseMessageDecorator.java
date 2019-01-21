package pl.drakeprogrammer.beans.decorators;

import org.springframework.stereotype.Component;

import static pl.drakeprogrammer.beans.decorators.MessageDecoratorType.DecoratorType.LOWER_CASE_MESSAGE_DECORATOR;

@Component
@MessageDecoratorType(LOWER_CASE_MESSAGE_DECORATOR)
public class LowerCaseMessageDecorator implements MessageDecorator {

	@Override
	public String decorate(String message) {
		return message.toLowerCase();
	}
}
