package pl.drakeprogrammer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.drakeprogrammer.components.ShoppingCartComponent;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	private ShoppingCartComponent shoppingCartComponent;

	@Autowired
	public ShoppingCartController(ShoppingCartComponent shoppingCartComponent) {
		this.shoppingCartComponent = shoppingCartComponent;
	}

	@PostMapping("/add")
	public String addProduct(@RequestParam String product) {
		shoppingCartComponent.addProduct(product);
		return "redirect:/";
	}

	@GetMapping("/allProducts")
	public String showAllProducts() {
		shoppingCartComponent.getProducts().forEach(System.out::println);
		return "redirect:/";
	}

}
