package com.example.projetmicroservice.entities;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity

public class Candidat {
    @Id

    private Integer idCandidat;
    private String nom;
    private String prenom;
    private String email;

    public Candidat() {

    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Integer idCandidat) {
        this.idCandidat = idCandidat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Candidat(Integer idCandidat, String nom, String prenom, String email) {
        this.idCandidat = idCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }


}
