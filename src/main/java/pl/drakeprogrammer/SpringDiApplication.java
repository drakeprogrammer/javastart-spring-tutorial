package pl.drakeprogrammer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.drakeprogrammer.beans.prototype_into_prototype_scope_test.NumberDoubleMessagePrinter;
import pl.drakeprogrammer.beans.prototype_into_singleton_scope_test.LongNumberMessagePrinter;
import pl.drakeprogrammer.beans.singleton_into_prototype_scope_test.GaussianNumberMessagePrinter;
import pl.drakeprogrammer.beans.singleton_into_singleton_scope_test.NumberIntegerMessagePrinter;

@Configuration
@ComponentScan
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

		NumberIntegerMessagePrinter numberIntegerMessagePrinter1 = ctx.getBean(NumberIntegerMessagePrinter.class);
		numberIntegerMessagePrinter1.printResults();
		NumberIntegerMessagePrinter numberIntegerMessagePrinter2 = ctx.getBean(NumberIntegerMessagePrinter.class);
		numberIntegerMessagePrinter2.printResults();

		System.out.println();

		GaussianNumberMessagePrinter gaussianNumberMessagePrinter1 = ctx.getBean(GaussianNumberMessagePrinter.class);
		gaussianNumberMessagePrinter1.printResults();
		GaussianNumberMessagePrinter gaussianNumberMessagePrinter2 = ctx.getBean(GaussianNumberMessagePrinter.class);
		gaussianNumberMessagePrinter2.printResults();

		System.out.println();

		LongNumberMessagePrinter longNumberMessagePrinter1 = ctx.getBean(LongNumberMessagePrinter.class);
		longNumberMessagePrinter1.printResults();
		LongNumberMessagePrinter longNumberMessagePrinter2 = ctx.getBean(LongNumberMessagePrinter.class);
		longNumberMessagePrinter2.printResults();

		System.out.println();

		NumberDoubleMessagePrinter numberDoubleMessagePrinter1 = ctx.getBean(NumberDoubleMessagePrinter.class);
		numberDoubleMessagePrinter1.printResults();
		NumberDoubleMessagePrinter numberDoubleMessagePrinter2 = ctx.getBean(NumberDoubleMessagePrinter.class);
		numberDoubleMessagePrinter2.printResults();

		ctx.close();
	}
}
