package fr.dauphine.heal.ejb.services.impl;

import fr.dauphine.heal.beans.CentreMedicalBean;
import fr.dauphine.heal.busnessobjects.CentreMedicalBo;
import fr.dauphine.heal.ejb.services.api.CentreMedicalService;

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
public class CentreMedicalServiceImpl implements CentreMedicalService {

    @PersistenceUnit(name = "heal")
    EntityManagerFactory emf;

    @Override
    public void save(CentreMedicalBo centreMedicalBo) {

    }

    @Override
    public void update(CentreMedicalBo centreMedicalBo) {

    }

    @Override
    public CentreMedicalBean findById(int id) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CentreMedicalBean> criteria = builder.createQuery(CentreMedicalBean.class);
        Root<CentreMedicalBean> centreRequest = criteria.from(CentreMedicalBean.class);
        Predicate idPredicate = builder.equal(centreRequest.get("id"), id);
        criteria.where(idPredicate);
        CentreMedicalBean centreMedicalBean = null;
        try {
            centreMedicalBean = em.createQuery(criteria).getSingleResult();
        }catch (NoResultException noResultException){
            System.out.println("Centre with id: " + id + "does not exist");
            //noResultException.printStackTrace();
        }
        return centreMedicalBean;
    }

    @Override
    public List<CentreMedicalBean> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CentreMedicalBean> criteria = builder.createQuery(CentreMedicalBean.class);
        Root<CentreMedicalBean> rootEntry = criteria.from(CentreMedicalBean.class);
        CriteriaQuery<CentreMedicalBean> all = criteria.select(rootEntry);
        TypedQuery<CentreMedicalBean> allQuery = em.createQuery(all);

        return allQuery.getResultList();
    }
}
