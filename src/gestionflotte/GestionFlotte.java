package gestionflotte;

import gestionflotte.modeles.Vehicule;

import java.util.ArrayList;

public class GestionFlotte {

    private ArrayList<Vehicule> vehicules;

    public GestionFlotte() {
        vehicules = new ArrayList<>();
    }

    public void ajouterVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public void afficherVehicules() {

        if (vehicules.isEmpty()) {
            System.out.println("Aucun véhicule.");
            return;
        }

        for (Vehicule vehicule : vehicules) {
            vehicule.afficherInformations();
        }
    }

        public Vehicule rechercherVehicule(String id) {

            for (Vehicule vehicule : vehicules) {

                if (vehicule.getId().equalsIgnoreCase(id)) {
                    return vehicule;
                }

            }

            return null;
        }

        public void louerVehicule(String id) {

        Vehicule vehicule = rechercherVehicule(id);

        if (vehicule == null) {
            System.out.println("Véhicule introuvable.");
            return;
        }

        try {
            vehicule.louer();
            System.out.println("Location effectuée.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void retournerVehicule(String id, double nouveauKilometrage) {

        Vehicule vehicule = rechercherVehicule(id);

        if (vehicule == null) {
            System.out.println("Véhicule introuvable.");
            return;
        }

        try {

            vehicule.retourner(nouveauKilometrage);

            System.out.println("Retour effectué.");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }

    public void signalerEntretien(String id) {

        Vehicule vehicule = rechercherVehicule(id);

        if (vehicule == null) {
            System.out.println("Véhicule introuvable.");
            return;
        }

        vehicule.signalerEntretien();

        System.out.println("Entretien signalé.");
    }

    public void terminerEntretien(String id) {

        Vehicule vehicule = rechercherVehicule(id);

        if (vehicule == null) {
            System.out.println("Véhicule introuvable.");
            return;
        }

        vehicule.terminerEntretien();

        System.out.println("Entretien terminé.");
    }

    public int calculerNombreVehicules() {
        return vehicules.size();
    }

    public int calculerVehiculesDisponibles() {

        int compteur = 0;

        for (Vehicule vehicule : vehicules) {

            if (vehicule.isDisponible()) {
                compteur++;
            }
        }

        return compteur;
    }

    public double calculerKilometrageMoyen() {

        if (vehicules.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Vehicule vehicule : vehicules) {
            total += vehicule.getKilometrage();
        }

        return total / vehicules.size();
    }

    public double calculerTarifMoyen() {

        if (vehicules.isEmpty()) {
            return 0;
        }

        double total = 0;

        for (Vehicule vehicule : vehicules) {
            total += vehicule.getTarifJournalier();
        }

        return total / vehicules.size();
    }

    public int calculerVehiculesEnEntretien() {

        int compteur = 0;

        for (Vehicule vehicule : vehicules) {

            if (vehicule.isEntretienNecessaire()) {
                compteur++;
            }
        }

        return compteur;
    }

    public void afficherStatistiques() {

        System.out.println("--- Statistiques de la flotte ---");

        System.out.println(
                "Nombre total de véhicules : "
                        + calculerNombreVehicules()
        );

        System.out.println(
                "Véhicules disponibles : "
                        + calculerVehiculesDisponibles()
        );

        System.out.println(
                "Kilométrage moyen : "
                        + calculerKilometrageMoyen()
        );

        System.out.println(
                "Tarif journalier moyen : "
                        + calculerTarifMoyen()
        );

        System.out.println(
                "Véhicules en entretien : "
                        + calculerVehiculesEnEntretien()
        );
    }
}