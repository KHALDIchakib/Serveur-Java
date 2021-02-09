package fr.dauphine.heal.busnessobjects;

import fr.dauphine.heal.beans.ExerceBean;
import fr.dauphine.heal.beans.RendezVousBean;
import fr.dauphine.heal.beans.UserBean;
import org.apache.commons.validator.EmailValidator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class UserBo {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String anneeNaissence;
    private String adresse;
    private String type;
    private String statut;
    private List<RendezVousBean> rendezVousBeansPatient;
    private List<RendezVousBean> rendezVousBeansMedecin;
    private List<ExerceBean> exerceBeansMedecin;

    public UserBo(UserBean userBean){
        this.id = userBean.getId();
        this.nom = userBean.getNom();
        this.prenom = userBean.getPrenom();
        this.email = userBean.getEmail();
        this.password = userBean.getPassword();
        this.telephone = userBean.getTelephone();
        this.anneeNaissence = userBean.getAnneeNaissence();
        this.adresse = userBean.getAdresse();
        this.type = userBean.getType();
        this.statut = userBean.getStatut();
        this.rendezVousBeansPatient = new ArrayList<>();
        this.rendezVousBeansMedecin = new ArrayList<>();
        this.exerceBeansMedecin = new ArrayList<>();
        this.rendezVousBeansPatient.addAll(userBean.getRendezVousBeansPatient());
        this.rendezVousBeansMedecin.addAll(userBean.getRendezVousBeansMedecin());
        this.exerceBeansMedecin.addAll(userBean.getExerceBeansMedecin());
    }

    public UserBo(String nom, String prenom, String email, String password, String telephone, String anneeNaissence, String adresse, String type, String statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.anneeNaissence = anneeNaissence;
        this.adresse = adresse;
        this.type = type;
        this.statut = statut;
        this.rendezVousBeansPatient = new ArrayList<>();
        this.rendezVousBeansMedecin = new ArrayList<>();
        this.exerceBeansMedecin = new ArrayList<>();
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

    public List<RendezVousBean> getRendezVousBeansPatient() {
        return rendezVousBeansPatient;
    }

    public void setRendezVousBeansPatient(Set<RendezVousBean> rendezVousBeansPatient) {
        this.rendezVousBeansPatient.clear();
        this.rendezVousBeansPatient.addAll(rendezVousBeansPatient);
    }

    public List<RendezVousBean> getRendezVousBeansMedecin() {
        return rendezVousBeansMedecin;
    }

    public void setRendezVousBeansMedecin(Set<RendezVousBean> rendezVousBeansMedecin) {
        this.rendezVousBeansMedecin.clear();
        this.rendezVousBeansMedecin.addAll(rendezVousBeansMedecin);
    }

    public List<ExerceBean> getExerceBeansMedecin() {
        return exerceBeansMedecin;
    }

    public void setExerceBeansMedecin(Set<ExerceBean> exerceBeansMedecin) {
        this.exerceBeansMedecin.clear();
        this.exerceBeansMedecin .addAll(exerceBeansMedecin);
    }

    public boolean validateNom() {
        return nom.matches("[a-zA-Z]+");
    }

    public boolean validatePrenom() {
        return prenom.matches("[a-zA-Z]+");
    }

    public boolean validateEmailAddress(){
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email);
    }

    public boolean validatePhoneNumber(){
        return telephone.matches("(0|\\+33|0033)[1-9][0-9]{8}");
    }

    public boolean validateAnneeNaissance(){
        int anneeEnCours = Calendar.getInstance().get(Calendar.YEAR);
        int anneeDeNaissence;
        try {
            anneeDeNaissence = Integer.parseInt(this.anneeNaissence.trim());
        }catch (NumberFormatException numberFormatException){
            //numberFormatException.printStackTrace();
            return false;
        }
        int age = anneeEnCours - anneeDeNaissence;
        return (anneeDeNaissence <= anneeEnCours) && (age <= 120) ;
    }

    public String validateAttributes(){
        String errors ="";
        if (!validateNom() || !validatePrenom() )
            errors = errors + "Le nom et le prénom ne doit contenir que des caractères alpha! ";
        if (!validateEmailAddress())
            errors = errors + " L'adresse mail fournie n'est pas valide! ";
        if (!validatePhoneNumber())
            errors = errors + " Le numéro de téléphone n'est pas valide!";
        if (this.type.equals("patient")) {
            if (!validateAnneeNaissance())
                errors = errors + " L'année de naissence n'est pas valide! ";
        }
        return errors;
    }

    public void update(String nom, String prenom, String password, String telephone, String anneeNaissence, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.telephone = telephone;
        this.anneeNaissence = anneeNaissence;
        this.adresse = adresse;
    }
}
