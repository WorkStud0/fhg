package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Commande;


public interface CommandeService {
	
    List < Commande > getAllCommandes();
    void saveCommande(Commande commande);
    Commande getCommandeById(long id);
    void deleteCommandeById(long id);

}
