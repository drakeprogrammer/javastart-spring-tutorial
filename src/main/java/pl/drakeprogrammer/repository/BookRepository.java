package pl.drakeprogrammer.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import pl.drakeprogrammer.model.Book;

@Component
public class BookRepository {

	private List<Book> books;

	public BookRepository() {
		books = new LinkedList<>();
	}

	public Book get(String isbn) {
		if (isbn == null || (isbn.length() != 13)) {
			throw new IllegalArgumentException("You have to provide valid ISBN number");
		}
		Book find = books.stream().filter(b -> isbn.equals(b.getIsbn())).findFirst().get();
		randomPause(300);
		return find;
	}

	public void add(Book book) {
		books.add(book);
		randomPause(1000);
	}

	private void randomPause(int maxTime) {
		try {
			Thread.sleep(new Random().nextInt(maxTime));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
