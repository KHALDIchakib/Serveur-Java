package fr.dauphine.heal.busnessobjects;


import fr.dauphine.heal.beans.ExerceBean;

import java.util.Set;

public class SpecialiteBo {

    private int id;
    private String nom;
    private Set<ExerceBean> exerceBeans;

    public SpecialiteBo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<ExerceBean> getExerceBeans() {
        return exerceBeans;
    }

    public void setExerceBeans(Set<ExerceBean> exerceBeans) {
        this.exerceBeans = exerceBeans;
    }
}
