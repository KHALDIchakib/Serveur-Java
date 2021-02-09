package fr.dauphine.heal.beans;

import javax.persistence.*;

@Entity
@Table( name = "rdv")
public class RendezVousBean {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn( name = "medecin_id")
    private UserBean medecin;

    @ManyToOne
    @JoinColumn( name = "centre_id")
    private CentreMedicalBean centre;

    @ManyToOne
    @JoinColumn( name = "patient_id")
    private UserBean patient;

    @Column(name = "date")
    private String date;

    public RendezVousBean(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserBean getMedecin() {
        return medecin;
    }

    public void setMedecin(UserBean medecin) {
        this.medecin = medecin;
    }

    public CentreMedicalBean getCentre() {
        return centre;
    }

    public void setCentre(CentreMedicalBean centre) {
        this.centre = centre;
    }

    public UserBean getPatient() {
        return patient;
    }

    public void setPatient(UserBean patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
