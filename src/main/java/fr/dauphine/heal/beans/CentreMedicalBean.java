package fr.dauphine.heal.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "centre")
public class CentreMedicalBean {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom_centre")
    private String nom;

    @Column(name = "numeroPhone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RendezVousBean> rendezVousBeans;

    @OneToMany(mappedBy = "centreExerce", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExerceBean> exerceBeans;

    public CentreMedicalBean() {
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
