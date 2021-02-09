package fr.dauphine.heal.beans;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "user")
public class UserBean {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "numeroPhone")
    private String telephone;

    @Column(name = "annee_naissence")
    private String anneeNaissence;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "type")
    private String type;

    @Column(name = "statut")
    private String statut;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RendezVousBean> rendezVousBeansPatient;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RendezVousBean> rendezVousBeansMedecin;

    @OneToMany(mappedBy = "medecinExerce", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ExerceBean> exerceBeansMedecin ;

    public UserBean(){
    }

    public UserBean(fr.dauphine.heal.busnessobjects.UserBo userBo){
        this.nom = userBo.getNom();
        this.prenom = userBo.getPrenom();
        this.email = userBo.getEmail();
        this.password = userBo.getPassword();
        this.telephone = userBo.getTelephone();
        this.anneeNaissence = userBo.getAnneeNaissence();
        this.adresse = userBo.getAdresse();
        this.type = userBo.getType();
        this.statut = userBo.getStatut();
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAnneeNaissence() {
        return anneeNaissence;
    }

    public void setAnneeNaissence(String anneeNaissence) {
        this.anneeNaissence = anneeNaissence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Set<RendezVousBean> getRendezVousBeansPatient() {
        return rendezVousBeansPatient;
    }

    public void setRendezVousBeansPatient(Set<RendezVousBean> rendezVousBeansPatient) {
        this.rendezVousBeansPatient = rendezVousBeansPatient;
    }

    public Set<RendezVousBean> getRendezVousBeansMedecin() {
        return rendezVousBeansMedecin;
    }

    public void setRendezVousBeansMedecin(Set<RendezVousBean> rendezVousBeansMedecin) {
        this.rendezVousBeansMedecin = rendezVousBeansMedecin;
    }

    public Set<ExerceBean> getExerceBeansMedecin() {
        return exerceBeansMedecin;
    }

    public void setExerceBeansMedecin(Set<ExerceBean> exerceBeansMedecin) {
        this.exerceBeansMedecin = exerceBeansMedecin;
    }
}
