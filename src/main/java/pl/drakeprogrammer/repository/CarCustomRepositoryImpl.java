package pl.drakeprogrammer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarCustomRepositoryImpl implements CarCustomRepository {

	@PersistenceContext(unitName = "spring-jpa-pu")
	private EntityManager em;

	@Override
	public List<String> findAllBrandOrById(@Nullable Long id) {
		String sqlQuery = "SELECT c.brand from Car c " + (id == null ? "" : " WHERE c.id = :id");

		TypedQuery<String> query = em.createQuery(sqlQuery, String.class);

		if (id != null) {
			query.setParameter("id", id);
		}

		return query.getResultList();
	}
}
