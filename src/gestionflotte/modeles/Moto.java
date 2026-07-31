package gestionflotte.modeles;

import gestionflotte.exceptions.DonneeInvalideException;
import gestionflotte.interfaces.Louable;
import gestionflotte.exceptions.VehiculeIndisponibleException;

public class Moto extends Vehicule {

    public Moto(String id, String marque, String modele,
                int annee, double kilometrage,
                double tarifJournalier, boolean disponible, boolean entretienNecessaire) {

        super(id, marque, modele, annee,
                kilometrage, tarifJournalier, disponible, entretienNecessaire);
    }

    @Override
    public double calculerTarifLocation(int nombreJours) {
        double prixNormal = getTarifJournalier() * nombreJours;
        return prixNormal * 0.90;
    }

    @Override
    public void louer() throws VehiculeIndisponibleException {

        if (!isDisponible()) {
            throw new VehiculeIndisponibleException(
                    "La moto est déjà louée.");
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