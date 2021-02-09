package fr.dauphine.heal.ejb.services.api;

import fr.dauphine.heal.beans.RendezVousBean;
import fr.dauphine.heal.busnessobjects.RendezVousBo;

import java.util.List;

public interface RendezVousService {

    void save(RendezVousBo rendezVousBo);
    void update(RendezVousBo rendezVousBo);
    RendezVousBean findById(int id);
    List<RendezVousBean> findAll();
}
