package pl.drakeprogrammer.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import pl.drakeprogrammer.profiles.DevProfile;
import pl.drakeprogrammer.profiles.ProdProfile;

@Configuration
@PropertySource("classpath:appConfig.properties")
public class AppConfig {

	@Bean
	@DevProfile
	public DatabaseDatasource getH2Datasource() {
		return () -> Arrays.asList("Dev1", "Dev2", "Dev3", "Dev4", "Dev5");
	}

	@Bean
	@ProdProfile
	public DatabaseDatasource getMySqlDatasource() {
		return new DatabaseDatasource() {
			@Override
			public List<String> getDatabase() {
				try {
					Path filePath = new File(getClass().getResource("/data.txt").toURI()).toPath();
					return Files.readAllLines(filePath);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
				return new ArrayList<>();
			}
		};
	}

}
