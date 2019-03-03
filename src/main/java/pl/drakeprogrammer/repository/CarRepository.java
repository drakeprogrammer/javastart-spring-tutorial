package pl.drakeprogrammer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.drakeprogrammer.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>, CarCustomRepository {

	@Query("SELECT c FROM Car c WHERE c.brand = :brand")
	List<Car> findByBrandCustom(@Param("brand") String bran);

	@Query(name = "Car.findByNameCustom")
	List<Car> findByNameCustom(@Param("name") String name);

	Car findFirstByBrand(String brand);
	Car findTopByBrand(String brand);

	List<Car> findFirst3ByBrand(String brand);
	List<Car> findTop3ByBrand(String brand);

	List<Car> findAllByBrandAndPrice(String brand, double price);
	List<Car> findAllByBrandOrBrand(String brand1, String brand2);

	List<Car> findAllByBrandLike(String pattern);
	List<Car> findAllByNameEndingWith(String pattern);

	List<Car> findAllByPriceLessThan(double price);
	List<Car> findAllByPriceBetween(double price1, double price2);

}
