package fr.dauphine.heal.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "specialite")
public class SpecialiteBean {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom_specialite")
    private String nom;

    @OneToMany(mappedBy = "specialiteExerce", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExerceBean> exerceBeans;

   public SpecialiteBean(){

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
