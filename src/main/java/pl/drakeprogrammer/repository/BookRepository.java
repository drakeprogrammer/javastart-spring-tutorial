package pl.drakeprogrammer.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import pl.drakeprogrammer.model.Book;

@Component
public class BookRepository {

	@PersistenceUnit
	private EntityManagerFactory emFactory;

	public void save(Book book) {
		EntityManager entityManager = emFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(book);
		tx.commit();
		entityManager.close();
	}

	public Book findById(Long id) {
		EntityManager entityManager = emFactory.createEntityManager();
		Book book = entityManager.find(Book.class, id);
		entityManager.close();
		return book;
	}

}
