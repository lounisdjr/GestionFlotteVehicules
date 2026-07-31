package gestionflotte.utils;

import gestionflotte.GestionFlotte;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateurRapport {

    public static void genererRapport(
            String cheminFichier,
            GestionFlotte flotte) {

        try {
            FileWriter fichier = new FileWriter(cheminFichier);

            fichier.write("--- Rapport de la flotte ---\n");

            fichier.write(
                    "Nombre total de véhicules : "
                            + flotte.calculerNombreVehicules()
                            + "\n"
            );

            fichier.write(
                    "Véhicules disponibles : "
                            + flotte.calculerVehiculesDisponibles()
                            + "\n"
            );

            fichier.write(
                    "Kilométrage moyen : "
                            + flotte.calculerKilometrageMoyen()
                            + "\n"
            );

            fichier.write(
                    "Tarif journalier moyen : "
                            + flotte.calculerTarifMoyen()
                            + "\n"
            );

            fichier.write(
                    "Véhicules en entretien : "
                            + flotte.calculerVehiculesEnEntretien()
                            + "\n"
            );

            fichier.close();

            System.out.println("Rapport généré avec succès.");

        } catch (IOException e) {
            System.out.println(
                    "Erreur lors de la création du rapport : "
                            + e.getMessage()
            );
        }
    }
}