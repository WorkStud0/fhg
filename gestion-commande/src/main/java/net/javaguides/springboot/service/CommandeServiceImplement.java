package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Commande;
import net.javaguides.springboot.repository.CommandeRepository;

@Service
public class CommandeServiceImplement implements CommandeService {
	
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List < Commande > getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public void saveCommande(Commande commande) {
        this.commandeRepository.save(commande);
    }

    @Override
    public Commande getCommandeById(long id) {
        Optional < Commande > optional = commandeRepository.findById(id);
        Commande commande = null;
        if (optional.isPresent()) {
            commande = optional.get();
        } else {
            throw new RuntimeException(" Order not found for id :: " + id);
        }
        return commande;
    }

    @Override
    public void deleteCommandeById(long id) {
        this.commandeRepository.deleteById(id);
    }


}
