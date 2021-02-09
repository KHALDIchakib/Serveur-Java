package fr.dauphine.heal.ejb.services.api;

import fr.dauphine.heal.beans.CentreMedicalBean;
import fr.dauphine.heal.busnessobjects.CentreMedicalBo;

import java.util.List;

public interface CentreMedicalService {

    void save(CentreMedicalBo centreMedicalBo);
    void update(CentreMedicalBo centreMedicalBo);
    CentreMedicalBean findById(int id);
    List<CentreMedicalBean> findAll();
}
