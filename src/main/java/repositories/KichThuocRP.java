package repositories;

import entities.KichThuoc;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class KichThuocRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<KichThuoc> findAll() {
        String hql = "Select entity from KichThuoc entity";
        Query q = hSession.createQuery(hql, KichThuoc.class);
        return q.getResultList();
    }

    public void create(KichThuoc kt) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            hSession.persist(kt);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public void update(KichThuoc kt) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            hSession.merge(kt);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public void delete(KichThuoc kt) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            hSession.remove(kt);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public KichThuoc findById(int id) {
        return this.hSession.find(KichThuoc.class, id);
    }

}
