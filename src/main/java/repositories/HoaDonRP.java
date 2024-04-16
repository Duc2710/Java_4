package repositories;

import entities.HoaDon;
import entities.HoaDon;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class HoaDonRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<HoaDon> findAll() {
        String hql = "Select entity from HoaDon entity";
        Query q = hSession.createQuery(hql, HoaDon.class);
        return q.getResultList();
    }

    public void create(HoaDon hd) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.persist(hd);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }

    }

    public void update(HoaDon hd) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.merge(hd);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public void delete(HoaDon hd) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.remove(hd);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public HoaDon findById(int hd) {
        return this.hSession.find(HoaDon.class, hd);
    }
}
