package fr.dauphine.heal.busnessobjects;

import fr.dauphine.heal.beans.CentreMedicalBean;
import fr.dauphine.heal.beans.SpecialiteBean;
import fr.dauphine.heal.beans.UserBean;

public class ExerceBo {

    private int id;
    private UserBean medecinExerce;
    private CentreMedicalBean centreExerce;
    private SpecialiteBean specialiteExerce;

    public ExerceBo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getMedecinExerce() {
        return medecinExerce;
    }

    public void setMedecinExerce(UserBean medecinExerce) {
        this.medecinExerce = medecinExerce;
    }

    public CentreMedicalBean getCentreExerce() {
        return centreExerce;
    }

    public void setCentreExerce(CentreMedicalBean centreExerce) {
        this.centreExerce = centreExerce;
    }

    public SpecialiteBean getSpecialiteExerce() {
        return specialiteExerce;
    }

    public void setSpecialiteExerce(SpecialiteBean specialiteExerce) {
        this.specialiteExerce = specialiteExerce;
    }
}
