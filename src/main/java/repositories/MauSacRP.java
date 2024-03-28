package repositories;

import entities.MauSac;
import jakarta.persistence.Query;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class MauSacRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<MauSac> findAll() {
        String hql = "Select entity From MauSac entity";
        Query q = hSession.createQuery(hql, MauSac.class);
        return q.getResultList();
    }

    public void create(MauSac ms) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.persist(ms);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }
    public void update(MauSac ms) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.merge(ms);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }
    public void delete(MauSac ms) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.remove(ms);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }
}
