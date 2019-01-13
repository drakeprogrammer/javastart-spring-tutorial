package pl.drakeprogrammer.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.drakeprogrammer.beans.MessagePrinter;

public class SpringDiApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
		MessagePrinter printer = ctx.getBean(MessagePrinter.class);
		printer.print();
		ctx.close();
	}
}
