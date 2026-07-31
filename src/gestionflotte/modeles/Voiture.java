package gestionflotte.modeles;

import gestionflotte.exceptions.DonneeInvalideException;
import gestionflotte.interfaces.Louable;
import gestionflotte.exceptions.VehiculeIndisponibleException;

public class Voiture extends Vehicule {

    public Voiture(String id, String marque, String modele,
                   int annee, double kilometrage,
                   double tarifJournalier, boolean disponible, boolean entretienNecessaire) {

        super(id, marque, modele, annee, kilometrage, tarifJournalier, disponible, entretienNecessaire);
    }
    @Override
    public double calculerTarifLocation(int nombreJours) {
        return getTarifJournalier() * nombreJours;
    }

    @Override
    public void louer() throws VehiculeIndisponibleException {

        if (!isDisponible()) {
            throw new VehiculeIndisponibleException(
                    "Le véhicule est déjà loué.");
        }

        setDisponible(false);
    }

    @Override
    public void retourner(double nouveauKilometrage)
            throws DonneeInvalideException {

        if (nouveauKilometrage < getKilometrage()) {
            throw new DonneeInvalideException(
                    "Kilométrage invalide.");
        }

        setKilometrage(nouveauKilometrage);
        setDisponible(true);
    }
}
