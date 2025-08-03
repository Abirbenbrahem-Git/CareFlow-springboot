package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bulletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbulletin;

    private String reference;
    private String nomadherent;
    private String nommalade;

    @Enumerated(EnumType.STRING)
    private TypeMalade typemalade;

    private String adresse;
    private Date datenaissance;
    private Date datedepot;
    private Date datesoin;

    @Enumerated(EnumType.STRING)
    private EtatBulletin etat;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] fichier;


    public Integer getIdbulletin() {
        return idbulletin;
    }

    public void setIdbulletin(Integer idbulletin) {
        this.idbulletin = idbulletin;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNomadherent() {
        return nomadherent;
    }

    public void setNomadherent(String nomadherent) {
        this.nomadherent = nomadherent;
    }

    public String getNommalade() {
        return nommalade;
    }

    public void setNommalade(String nommalade) {
        this.nommalade = nommalade;
    }

    public TypeMalade getTypemalade() {
        return typemalade;
    }

    public void setTypemalade(TypeMalade typemalade) {
        this.typemalade = typemalade;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public Date getDatesoin() {
        return datesoin;
    }

    public void setDatesoin(Date datesoin) {
        this.datesoin = datesoin;
    }

    public EtatBulletin getEtat() {
        return etat;
    }

    public void setEtat(EtatBulletin etat) {
        this.etat = etat;
    }

    public byte[] getFichier() {
        return fichier;
    }

    public void setFichier(byte[] fichier) {
        this.fichier = fichier;
    }

    public enum TypeMalade {
        adherent, conjoint, enfant
    }

    public enum EtatBulletin {
        en_cours, valide, reffuse
    }
}