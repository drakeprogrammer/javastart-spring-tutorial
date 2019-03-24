package pl.drakeprogrammer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.drakeprogrammer.model.Article;

@Controller
public class ArticleController {

	@PostMapping("/add")
	public String addArticle(@ModelAttribute Article formArticle, Model model) {
		if (checkNotEmpty(formArticle)) {
			model.addAttribute("formArticle", formArticle);
			return "success";
		}

		return "redirect:sorry";
	}

	@GetMapping("/sorry")
	public String error() {
		return "errorMessage";
	}

	private boolean checkNotEmpty(Article article) {
		return (article.getTitle() != null && !article.getTitle().isEmpty()) && (article.getContent() != null
				&& !article.getContent().isEmpty());
	}
}
