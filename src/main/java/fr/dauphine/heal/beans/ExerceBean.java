package fr.dauphine.heal.beans;

import javax.persistence.*;

@Entity
@Table( name = "exerce")
public class ExerceBean {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn( name = "medecin_id")
    private UserBean medecinExerce;

    @ManyToOne
    @JoinColumn( name = "centre_id")
    private CentreMedicalBean centreExerce;

    @ManyToOne
    @JoinColumn( name = "specialite_id")
    private SpecialiteBean specialiteExerce;

    public ExerceBean(){

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
