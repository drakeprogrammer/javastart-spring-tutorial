package pl.drakeprogrammer.beans.singleton_into_singleton_scope_test;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class NumberIntegerMessageProducer {

	private int randomNumber;

	public NumberIntegerMessageProducer() {
		randomNumber = new Random().nextInt();
	}

	public int getRandomNumber() {
		return randomNumber;
	}
}
