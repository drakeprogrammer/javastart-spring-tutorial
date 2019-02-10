package pl.drakeprogrammer.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("spring-jpa-pu");

		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
		emf.setJpaPropertyMap(properties);

		emf.setDataSource(dataSource);
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setPackagesToScan("pl.drakeprogrammer.model");

		return emf;
	}

	@Bean
	public JpaVendorAdapter createJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public DataSource createDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/spring_framework");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setInitialSize(5);
		return basicDataSource;
	}
}
