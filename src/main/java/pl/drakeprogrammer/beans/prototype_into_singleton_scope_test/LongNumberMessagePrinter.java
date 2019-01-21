package pl.drakeprogrammer.beans.prototype_into_singleton_scope_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LongNumberMessagePrinter {

	private LongNumberMessageProducer longNumberMessageProducer;

	@Autowired
	public LongNumberMessagePrinter(LongNumberMessageProducer longNumberMessageProducer) {
		this.longNumberMessageProducer = longNumberMessageProducer;
	}

	public void printResults() {
		System.out.println(
				"Prototype injected into Singleton. Result Long number always the same: " + longNumberMessageProducer
						.getLongNumber());
	}
}
