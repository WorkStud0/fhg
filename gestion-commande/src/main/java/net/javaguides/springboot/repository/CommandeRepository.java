package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
