package pl.drakeprogrammer.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.drakeprogrammer.repository")
public class JpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter, DataSource dataSource) {
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
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setShowSql(true);
		return hibernateJpaVendorAdapter;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/spring_framework");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setInitialSize(5);
		return basicDataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
