package pl.drakeprogrammer.beans.decorators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("upperCaseMessageDecorator")
public class UpperCaseMessageDecorator implements MessageDecorator {
	@Override
	public String decorate(String message) {
		return message.toUpperCase();
	}
}
