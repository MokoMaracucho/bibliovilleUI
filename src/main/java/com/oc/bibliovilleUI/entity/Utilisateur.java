package com.oc.bibliovilleUI.entity;

public class Utilisateur {

    private Long idUtilisateur;
    private String emailUtilisateur;
    private String motPasseUtilisateur;

    public Utilisateur() {
    }

    public Utilisateur(Long idUtilisateur, String emailUtilisateur, String motPasseUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.motPasseUtilisateur = motPasseUtilisateur;
    }

    public Utilisateur(String emailUtilisateur, String motPasseUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
        this.motPasseUtilisateur = motPasseUtilisateur;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getMotPasseUtilisateur() {
        return motPasseUtilisateur;
    }

    public void setMotPasseUtilisateur(String motPasseUtilisateur) {
        this.motPasseUtilisateur = motPasseUtilisateur;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", emailUtilisateur='" + emailUtilisateur + '\'' +
                ", motPasseUtilisateur='" + motPasseUtilisateur + '\'' +
                '}';
    }
}
