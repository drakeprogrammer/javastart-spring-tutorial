package pl.drakeprogrammer.beans.decorators;

import org.springframework.stereotype.Component;

@Component
@UpperCaseMessage
public class UpperCaseMessageDecorator implements MessageDecorator {
	@Override
	public String decorate(String message) {
		return message.toUpperCase();
	}
}
