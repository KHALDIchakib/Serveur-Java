package fr.dauphine.heal.ejb.services.impl;

import fr.dauphine.heal.beans.SpecialiteBean;
import fr.dauphine.heal.busnessobjects.SpecialiteBo;
import fr.dauphine.heal.ejb.services.api.SpecilaiteService;

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
public class SpecialiteServiceImpl implements SpecilaiteService {

    @PersistenceUnit(name = "heal")
    EntityManagerFactory emf;

    @Override
    public void save(SpecialiteBo specialiteBo) {

    }

    @Override
    public void update(SpecialiteBo specialiteBo) {

    }

    @Override
    public SpecialiteBean findById(int id) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<SpecialiteBean> criteria = builder.createQuery(SpecialiteBean.class);
        Root<SpecialiteBean> specialiteRequest = criteria.from(SpecialiteBean.class);
        Predicate idPredicate = builder.equal(specialiteRequest.get("id"), id);
        criteria.where(idPredicate);
        SpecialiteBean specialiteBean = null;
        try {
            specialiteBean = em.createQuery(criteria).getSingleResult();
        }catch (NoResultException noResultException){
            System.out.println("Specialité with id: " + id + "does not exist");
            //noResultException.printStackTrace();
        }
        return specialiteBean;
    }

    @Override
    public List<SpecialiteBean> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<SpecialiteBean> criteria = builder.createQuery(SpecialiteBean.class);
        Root<SpecialiteBean> rootEntry = criteria.from(SpecialiteBean.class);
        CriteriaQuery<SpecialiteBean> all = criteria.select(rootEntry);
        TypedQuery<SpecialiteBean> allQuery = em.createQuery(all);

        return allQuery.getResultList();
    }
}
