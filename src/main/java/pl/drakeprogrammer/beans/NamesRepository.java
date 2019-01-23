package pl.drakeprogrammer.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.drakeprogrammer.config.DatabaseDatasource;

@Component
public class NamesRepository {

	private DatabaseDatasource databaseDatasource;

	@Autowired
	public NamesRepository(DatabaseDatasource databaseDatasource) {
		this.databaseDatasource = databaseDatasource;
	}

	public List<String> getAll() {
		return databaseDatasource.getDatabase();
	}
}
