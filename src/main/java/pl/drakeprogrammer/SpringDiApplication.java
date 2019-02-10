package pl.drakeprogrammer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.drakeprogrammer.model.Book;
import pl.drakeprogrammer.repository.BookRepository;

@Configuration
@ComponentScan
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

		BookRepository bookRepository = ctx.getBean(BookRepository.class);
		Book book = new Book("1234567890123", "Pierwsza", "Pierwszy autor");
		bookRepository.save(book);

		System.out.println(bookRepository.findById(book.getId()));

		ctx.close();
	}
}
