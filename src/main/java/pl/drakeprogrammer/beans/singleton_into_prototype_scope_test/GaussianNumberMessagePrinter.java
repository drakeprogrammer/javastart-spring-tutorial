package pl.drakeprogrammer.beans.singleton_into_prototype_scope_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GaussianNumberMessagePrinter {

	private GaussianNumberMessageProducer gaussianNumberMessageProducer;

	@Autowired
	public GaussianNumberMessagePrinter(GaussianNumberMessageProducer gaussianNumberMessageProducer) {
		this.gaussianNumberMessageProducer = gaussianNumberMessageProducer;
	}

	public void printResults() {
		System.out.println("Singleton injected into Prototype. Result Gaussian number always the same: "
				+ gaussianNumberMessageProducer.getGaussianNumber());
	}
}
