package pl.drakeprogrammer.repository;

import java.util.List;

public interface CarCustomRepository {

	List<String> findAllBrandOrById(Long id);
}
