package pl.drakeprogrammer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.drakeprogrammer.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
