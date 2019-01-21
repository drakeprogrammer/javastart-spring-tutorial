package pl.drakeprogrammer.beans.singleton_into_singleton_scope_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberIntegerMessagePrinter {

	private NumberIntegerMessageProducer numberIntegerMessageProducer;

	@Autowired
	public NumberIntegerMessagePrinter(NumberIntegerMessageProducer numberIntegerMessageProducer) {
		this.numberIntegerMessageProducer = numberIntegerMessageProducer;
	}

	public void printResults() {
		System.out.println("Singleton injected into Singleton. Result Integer number always the same: "
				+ numberIntegerMessageProducer.getRandomNumber());
	}
}
