package pl.drakeprogrammer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.drakeprogrammer.model.Book;
import pl.drakeprogrammer.repository.BookRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

		BookRepository repo = ctx.getBean(BookRepository.class);
		repo.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
		repo.add(new Book("2345678901234", "Druga", "Drugi autor"));
		repo.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
		Book book = repo.get("1234567890123");
		System.out.println(book);

		ctx.close();
	}
}
