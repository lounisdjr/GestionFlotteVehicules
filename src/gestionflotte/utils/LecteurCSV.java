package gestionflotte.utils;

import gestionflotte.GestionFlotte;
import gestionflotte.modeles.Camion;
import gestionflotte.modeles.Moto;
import gestionflotte.modeles.Voiture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecteurCSV {

    public static void chargerVehicules(String cheminFichier,
                                        GestionFlotte flotte) {

        try {
            BufferedReader lecteur =
                    new BufferedReader(new FileReader(cheminFichier));

            String ligne;

            lecteur.readLine();

            while ((ligne = lecteur.readLine()) != null) {

                String[] donnees = ligne.split(",");

                String id = donnees[0];
                String type = donnees[1];
                String marque = donnees[2];
                String modele = donnees[3];
                int annee = Integer.parseInt(donnees[4]);
                double kilometrage = Double.parseDouble(donnees[5]);
                double tarifJournalier = Double.parseDouble(donnees[6]);
                boolean disponible = Boolean.parseBoolean(donnees[7]);
                boolean entretienNecessaire =
                        Boolean.parseBoolean(donnees[8]);

                if (kilometrage < 0 || tarifJournalier < 0) {
                    System.out.println(
                            "Donnée invalide ignorée : " + ligne
                    );
                    continue;
                }

                if (type.equalsIgnoreCase("Voiture")) {

                    Voiture voiture = new Voiture(
                            id,
                            marque,
                            modele,
                            annee,
                            kilometrage,
                            tarifJournalier,
                            disponible,
                            entretienNecessaire
                    );

                    flotte.ajouterVehicule(voiture);

                } else if (type.equalsIgnoreCase("Moto")) {

                    Moto moto = new Moto(
                            id,
                            marque,
                            modele,
                            annee,
                            kilometrage,
                            tarifJournalier,
                            disponible,
                            entretienNecessaire
                    );

                    flotte.ajouterVehicule(moto);

                } else if (type.equalsIgnoreCase("Camion")) {

                    Camion camion = new Camion(
                            id,
                            marque,
                            modele,
                            annee,
                            kilometrage,
                            tarifJournalier,
                            disponible,
                            entretienNecessaire
                    );

                    flotte.ajouterVehicule(camion);
                }
            }

            lecteur.close();

        } catch (IOException e) {
            System.out.println(
                    "Erreur de lecture : " + e.getMessage()
            );

        } catch (NumberFormatException e) {
            System.out.println(
                    "Erreur dans le format d'une donnée : "
                            + e.getMessage()
            );
        }
    }
}