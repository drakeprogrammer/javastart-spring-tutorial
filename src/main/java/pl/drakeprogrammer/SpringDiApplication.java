package pl.drakeprogrammer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.drakeprogrammer.beans.NamesRepository;

@Configuration
@ComponentScan
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);
		NamesRepository namesRepository = ctx.getBean(NamesRepository.class);
		namesRepository.getAll().forEach(System.out::println);
		ctx.close();
	}
}
