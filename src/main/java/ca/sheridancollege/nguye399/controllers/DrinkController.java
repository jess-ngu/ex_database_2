package ca.sheridancollege.nguye399.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ca.sheridancollege.nguye399.database.*;
import ca.sheridancollege.nguye399.drinks.Drink;

@Controller
public class DrinkController {

	@Autowired
	private DrinkRepository drinkRepo;

	@GetMapping("/") // localhost:8080
	public String goHome() {
		return "drinkhome.html";
	}

	@GetMapping("/drinkAdd") // localhost:8080/drinkAdd
	public String drinkAdd(Model model) {
		model.addAttribute("drink", new Drink());
		return "drinkadd.html";
	}

	@GetMapping("/validateDrink") // localhost:8080/validateDrink
	public String validateDrink(Model model, @ModelAttribute Drink drink) {
		drinkRepo.addDrink(drink);
		model.addAttribute("drink", new Drink());
		return "redirect:/drinkAdd";
	}

	@GetMapping("/drinkDisplay") // localhost:8080/drinkDisplay
	public String drinkDisplay(Model model) {
		model.addAttribute("drinks", drinkRepo.getDrinks());
		return "drinkdisplay.html";
	}
}
