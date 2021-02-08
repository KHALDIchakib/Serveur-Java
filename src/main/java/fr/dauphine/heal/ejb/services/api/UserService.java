package fr.dauphine.heal.ejb.services.api;

import fr.dauphine.heal.beans.UserBean;
import fr.dauphine.heal.busnessobjects.UserBo;

import java.util.List;

public interface UserService {

    void save(UserBo userBo);
    void update(UserBo userBo);
    UserBean findById(int id);
    UserBean findByEmail(String email);
    List<UserBean> findAll();
}
