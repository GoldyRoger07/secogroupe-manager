package com.secogroupe.manager.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    private String nif;

    private String adresse;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "etat_civil_id")
    private EtatCivil etatCivil;

    private int nombreEnfant;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    private LocalDate dateEmbauche;

    private double salaire;

    @ManyToOne
    @JoinColumn(name = "banque_id")
    private Banque banque;

    private String numCompteBancaire;

    @ManyToOne
    @JoinColumn(name = "type_conge_id")
    private TypeConge typeConge;

}
