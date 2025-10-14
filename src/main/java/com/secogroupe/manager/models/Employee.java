package com.secogroupe.manager.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String idEmployee;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private String sexe;

    private String nif;

    private String adresse;

    private String telephone;

    private String etatCivil;

    private int nombreEnfant;

    private String position;

    private String departement;

    private LocalDate dateEmbauche;

    private double salaire;

    private String nomCompteBancaire;

    private String numCompteBancaire;

    private String typeConge;
}
