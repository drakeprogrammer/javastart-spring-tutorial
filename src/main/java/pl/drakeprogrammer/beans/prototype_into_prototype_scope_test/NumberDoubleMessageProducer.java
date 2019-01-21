package pl.drakeprogrammer.beans.prototype_into_prototype_scope_test;

import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NumberDoubleMessageProducer {

	private double randomNumber;

	public NumberDoubleMessageProducer() {
		randomNumber = new Random().nextDouble();
	}

	public double getRandomNumber() {
		return randomNumber;
	}
}
