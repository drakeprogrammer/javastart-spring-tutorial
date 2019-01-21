package pl.drakeprogrammer.beans.prototype_into_singleton_scope_test;

import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LongNumberMessageProducer {

	private long longNumber;

	public LongNumberMessageProducer() {
		longNumber = new Random().nextLong();
	}

	public long getLongNumber() {
		return longNumber;
	}
}
