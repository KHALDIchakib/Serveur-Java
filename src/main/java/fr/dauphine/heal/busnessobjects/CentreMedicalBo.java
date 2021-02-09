package fr.dauphine.heal.busnessobjects;

import fr.dauphine.heal.beans.ExerceBean;
import fr.dauphine.heal.beans.RendezVousBean;

import java.util.Set;

public class CentreMedicalBo {

    private int id;
    private String nom;
    private String telephone;
    private String adresse;
    private Set<RendezVousBean> rendezVousBeans;
    private Set<ExerceBean> exerceBeans;

    public CentreMedicalBo(){

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<RendezVousBean> getRendezVousBeans() {
        return rendezVousBeans;
    }

    public void setRendezVousBeans(Set<RendezVousBean> rendezVousBeans) {
        this.rendezVousBeans = rendezVousBeans;
    }

    public Set<ExerceBean> getExerceBeans() {
        return exerceBeans;
    }

    public void setExerceBeans(Set<ExerceBean> exerceBeans) {
        this.exerceBeans = exerceBeans;
    }
}
