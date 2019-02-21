package pl.drakeprogrammer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.drakeprogrammer.model.Car;
import pl.drakeprogrammer.repository.CarRepository;

@Configuration
@ComponentScan
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("A4", "Audi", 49000.0));
		cars.add(new Car("Auris", "Toyota", 35000.0));
		cars.add(new Car("Insignia", "Opel", 29500.0));

		CarRepository carRepository = ctx.getBean(CarRepository.class);

		cars.forEach(carRepository::save);

		Car car1 = carRepository.findById(1L).get();
		carRepository.delete(car1);

		carRepository.findAll().forEach(System.out::println);
		ctx.close();
	}
}
