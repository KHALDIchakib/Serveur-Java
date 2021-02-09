package fr.dauphine.heal.ejb.services.impl;

import fr.dauphine.heal.beans.RendezVousBean;
import fr.dauphine.heal.busnessobjects.RendezVousBo;
import fr.dauphine.heal.ejb.services.api.RendezVousService;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class RendezVousServiceImpl implements RendezVousService {

    @PersistenceUnit(name = "heal")
    EntityManagerFactory emf;

    @Override
    public void save(RendezVousBo rendezVousBo) {

    }

    @Override
    public void update(RendezVousBo rendezVousBo) {

    }

    @Override
    public RendezVousBean findById(int id) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<RendezVousBean> criteria = builder.createQuery(RendezVousBean.class);
        Root<RendezVousBean> rdvRequest = criteria.from(RendezVousBean.class);
        Predicate idPredicate = builder.equal(rdvRequest.get("id"), id);
        criteria.where(idPredicate);
        RendezVousBean rendezVousBean = null;
        try {
            rendezVousBean = em.createQuery(criteria).getSingleResult();
        }catch (NoResultException noResultException){
            System.out.println("RDV with id: " + id + "does not exist");
            //noResultException.printStackTrace();
        }
        return rendezVousBean;
    }

    @Override
    public List<RendezVousBean> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<RendezVousBean> criteria = builder.createQuery(RendezVousBean.class);
        Root<RendezVousBean> rootEntry = criteria.from(RendezVousBean.class);
        CriteriaQuery<RendezVousBean> all = criteria.select(rootEntry);
        TypedQuery<RendezVousBean> allQuery = em.createQuery(all);

        return allQuery.getResultList();
    }
}
