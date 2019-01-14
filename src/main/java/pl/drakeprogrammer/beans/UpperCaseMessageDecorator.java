package pl.drakeprogrammer.beans;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseMessageDecorator implements MessageDecorator {
	@Override
	public String decorate(String message) {
		return message.toUpperCase();
	}
}
