package pl.drakeprogrammer.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartComponent {

	private List<String> products;

	public ShoppingCartComponent() {
		this.products = new ArrayList<>();
	}

	public List<String> getProducts() {
		return products;
	}

	public void addProduct(String product) {
		products.add(product);
	}

	@PostConstruct
	public void afterCreated() {
		System.out.println(this + " created");
	}

	@PreDestroy
	public void beforeDestroy() {
		System.out.println(this + " destroyed");
	}
}
