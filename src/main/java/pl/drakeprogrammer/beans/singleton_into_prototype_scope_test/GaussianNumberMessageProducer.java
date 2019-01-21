package pl.drakeprogrammer.beans.singleton_into_prototype_scope_test;

import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class GaussianNumberMessageProducer {

	private double gaussianNumber;

	public GaussianNumberMessageProducer() {
		gaussianNumber = new Random().nextGaussian();
	}

	public double getGaussianNumber() {
		return gaussianNumber;
	}
}
