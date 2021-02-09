package fr.dauphine.heal.ejb.services.api;


import fr.dauphine.heal.beans.SpecialiteBean;
import fr.dauphine.heal.busnessobjects.SpecialiteBo;

import java.util.List;

public interface SpecilaiteService {

    void save(SpecialiteBo specialiteBo);
    void update(SpecialiteBo specialiteBo);
    SpecialiteBean findById(int id);
    List<SpecialiteBean> findAll();
}
