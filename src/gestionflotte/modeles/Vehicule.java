package gestionflotte.modeles;

import gestionflotte.interfaces.Louable;

public abstract class Vehicule implements Louable {

    private String id;
    private String marque;
    private String modele;
    private int annee;
    private double kilometrage;
    private double tarifJournalier;
    private boolean disponible;
    private boolean entretienNecessaire;

    public Vehicule(String id, String marque, String modele, int annee,
                    double kilometrage, double tarifJournalier,
                    boolean disponible, boolean entretienNecessaire) {

        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.tarifJournalier = tarifJournalier;
        this.disponible = disponible;
        this.entretienNecessaire = entretienNecessaire;
    }

    public abstract double calculerTarifLocation(int nombreJours);

    public String getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getAnnee() {
        return annee;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public double getTarifJournalier() {
        return tarifJournalier;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public boolean isEntretienNecessaire() {
        return entretienNecessaire;
    }

    public void setEntretienNecessaire(boolean entretienNecessaire) {
        this.entretienNecessaire = entretienNecessaire;
    }
    public void signalerEntretien() {
        entretienNecessaire = true;
        disponible = false;
    }

    public void terminerEntretien() {
        entretienNecessaire = false;
        disponible = true;
    }
    public void afficherInformations() {
        System.out.println(
                id + " - " +
                        marque + " " +
                        modele + " - " +
                        annee + " - " +
                        kilometrage + " km - " +
                        tarifJournalier + " $/jour - Disponible : " +
                        disponible + " - Entretien : " +
                        entretienNecessaire
        );
    }
}