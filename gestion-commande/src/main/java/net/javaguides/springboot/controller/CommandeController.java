package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.Commande;
import net.javaguides.springboot.service.CommandeService;

@Controller
public class CommandeController {
	
    @Autowired
    private CommandeService commandeService;

    // display list of orders
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCommandes", commandeService.getAllCommandes());
        return "index";
    }

    @GetMapping("/showNewCommandeForm")
    public String showNewCommandeForm(Model model) {
        // create model attribute to bind form data
        Commande commande = new Commande();
        model.addAttribute("commande", commande);
        return "new_commande";
    }

    @PostMapping("/saveCommande")
    public String saveCommande(@ModelAttribute("commande") Commande commande) {
        // save order to database
        commandeService.saveCommande(commande);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get order from the service
        Commande commande = commandeService.getCommandeById(id);

        // set order as a model attribute to pre-populate the form
        model.addAttribute("commande", commande);
        return "update_commande";
    }

    @GetMapping("/deleteCommande/{id}")
    public String deleteCommande(@PathVariable(value = "id") long id) {

        // call delete order method 
        this.commandeService.deleteCommandeById(id);
        return "redirect:/";
    }

}
