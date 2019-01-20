package pl.drakeprogrammer.beans.decorators;

import org.springframework.stereotype.Component;

@Component
@LowerCaseMessage
public class LowerCaseMessageDecorator implements MessageDecorator {

	@Override
	public String decorate(String message) {
		return message.toLowerCase();
	}
}
