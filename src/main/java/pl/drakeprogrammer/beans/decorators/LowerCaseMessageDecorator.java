package pl.drakeprogrammer.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseMessageDecorator implements MessageDecorator {

	@Override
	public String decorate(String message) {
		return message.toLowerCase();
	}
}
