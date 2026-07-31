package gestionflotte;

import java.util.Scanner;
import gestionflotte.utils.GenerateurRapport;
import gestionflotte.utils.LecteurCSV;

public class Main {

    public static void main(String[] args) {

        GestionFlotte flotte = new GestionFlotte();

        LecteurCSV.chargerVehicules(
                "data/vehicules.csv",
                flotte
        );

        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println();
            System.out.println("===== GESTION DE FLOTTE =====");
            System.out.println("1. Afficher les véhicules");
            System.out.println("2. Louer un véhicule");
            System.out.println("3. Retourner un véhicule");
            System.out.println("4. Signaler un entretien");
            System.out.println("5. Terminer un entretien");
            System.out.println("6. Afficher les statistiques");
            System.out.println("7. Générer le rapport");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();

            switch (choix) {

                case 1:
                    flotte.afficherVehicules();
                    break;

                case 2:
                    System.out.print("Entrez l'ID du véhicule : ");
                    String idLocation = scanner.next();
                    flotte.louerVehicule(idLocation);
                    break;

                case 3:
                    System.out.print("Entrez l'ID du véhicule : ");
                    String idRetour = scanner.next();

                    System.out.print("Entrez le nouveau kilométrage : ");
                    double nouveauKilometrage = scanner.nextDouble();

                    flotte.retournerVehicule(idRetour, nouveauKilometrage);
                    break;

                case 4:
                    System.out.print("Entrez l'ID du véhicule : ");
                    String idEntretien = scanner.next();
                    flotte.signalerEntretien(idEntretien);
                    break;

                case 5:
                    System.out.print("Entrez l'ID du véhicule : ");
                    String idFinEntretien = scanner.next();
                    flotte.terminerEntretien(idFinEntretien);
                    break;

                case 6:
                    flotte.afficherStatistiques();
                    break;

                case 7:
                    GenerateurRapport.genererRapport(
                            "data/rapport.txt",
                            flotte
                    );
                    break;

                case 0:
                    System.out.println("Fermeture du programme.");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);

        scanner.close();

        System.out.println("Programme terminé.");
    }
}