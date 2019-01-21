package pl.drakeprogrammer.beans.prototype_into_prototype_scope_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NumberDoubleMessagePrinter {

	private NumberDoubleMessageProducer numberDoubleMessageProducer;

	@Autowired
	public NumberDoubleMessagePrinter(NumberDoubleMessageProducer numberDoubleMessageProducer) {
		this.numberDoubleMessageProducer = numberDoubleMessageProducer;
	}

	public void printResults() {
		System.out.println("Prototype injected into Prototype. Result Double number always different: "
				+ numberDoubleMessageProducer.getRandomNumber());
	}
}
