package com.example.demo.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iduser;

    private int cin;
    private String nom;
    private String prenom;
    private String mail;
    private int numtel;
    private String motdepasse;
    private String residence;

    @Enumerated(EnumType.STRING)
    private Role role;

    public int getIduser() { return iduser; }
    public void setIduser(int iduser) { this.iduser = iduser; }

    public int getCin() { return cin; }
    public void setCin(int cin) { this.cin = cin; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public int getNumtel() { return numtel; }
    public void setNumtel(int numtel) { this.numtel = numtel; }

    public String getMotdepasse() { return motdepasse; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }

    public String getResidence() { return residence; }
    public void setResidence(String residence) { this.residence = residence; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public enum Role {
        agent,
        responsable,
        admin
    }
}
