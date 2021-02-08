package fr.dauphine.heal.ejb.services.impl;

import fr.dauphine.heal.beans.UserBean;
import fr.dauphine.heal.busnessobjects.UserBo;
import fr.dauphine.heal.ejb.services.api.UserService;

import javax.ejb.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceImpl implements UserService {

    @PersistenceUnit(name = "doctolib")
    EntityManagerFactory emf;


    @Override
    public void save(UserBo userBo) {
        try {
            EntityManager em = emf.createEntityManager();
            EntityTransaction entityTransaction = em.getTransaction();
            UserBean userBean = new UserBean(userBo);
            entityTransaction.begin();
            em.persist(userBean);
            entityTransaction.commit();
        }catch (Exception exception){
            System.out.println("Erreur lors de l'ajout de " + userBo.getEmail() + " à la BDD");
            exception.printStackTrace();
        }
    }

    @Override
    public void update(UserBo userBo) {
        try {
            EntityManager em = emf.createEntityManager();
            EntityTransaction entityTransaction = em.getTransaction();
            UserBean userBean = findById(userBo.getId());
            userBean.setNom(userBo.getNom());
            userBean.setPrenom(userBo.getPrenom());
            userBean.setPassword(userBo.getPassword());
            userBean.setTelephone(userBo.getTelephone());
            userBean.setAnneeNaissence(userBo.getAnneeNaissence());
            userBean.setAdresse(userBo.getAdresse());

            entityTransaction.begin();
            em.merge(userBean);
            entityTransaction.commit();
        }catch (Exception exception){
            System.out.println("Erreur lors de l'ajout de " + userBo.getEmail() + " à la BDD");
            exception.printStackTrace();
        }
    }

    @Override
    public UserBean findById(int id) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserBean> criteria = builder.createQuery(UserBean.class);
        Root<UserBean> userRequest = criteria.from(UserBean.class);
        Predicate idPredicate = builder.equal(userRequest.get("id"), id);
        criteria.where(idPredicate);
        UserBean userBean = null;
        try {
            userBean = em.createQuery(criteria).getSingleResult();
        }catch (NoResultException noResultException){
            System.out.println("User with id: " + id + "does not exist");
            //noResultException.printStackTrace();
        }
        return userBean;
    }

    @Override
    public UserBean findByEmail(String email){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserBean> criteria = builder.createQuery(UserBean.class);
        Root<UserBean> userRequest = criteria.from(UserBean.class);
        Predicate idPredicate = builder.equal(userRequest.get("email"), email);
        criteria.where(idPredicate);
        UserBean userBean = null;
        try {
            userBean = em.createQuery(criteria).getSingleResult();
        }catch (NoResultException noResultException){
            System.out.println("User with email: " + email + " does not exist");
            //noResultException.printStackTrace();
        }
        return userBean;
    }

    @Override
    public List<UserBean> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserBean> criteria = builder.createQuery(UserBean.class);
        Root<UserBean> rootEntry = criteria.from(UserBean.class);
        CriteriaQuery<UserBean> all = criteria.select(rootEntry);
        TypedQuery<UserBean> allQuery = em.createQuery(all);

        return allQuery.getResultList();
    }
}
