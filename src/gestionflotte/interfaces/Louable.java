package gestionflotte.interfaces;

import gestionflotte.exceptions.DonneeInvalideException;
import gestionflotte.exceptions.VehiculeIndisponibleException;

public interface Louable {

    void louer() throws VehiculeIndisponibleException;

    void retourner(double nouveauKilometrage)
            throws DonneeInvalideException;

}