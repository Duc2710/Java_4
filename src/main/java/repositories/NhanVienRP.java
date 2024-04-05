package repositories;

import entities.MauSac;
import entities.NhanVien;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class NhanVienRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();

    public List<NhanVien> findAll() {
        String hql = "Select entity from NhanVien entity";
        Query q = hSession.createQuery(hql, NhanVien.class);
        return q.getResultList();
    }

    public void update(NhanVien nv) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.merge(nv);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public void delete(NhanVien nv) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.remove(nv);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public void create(NhanVien nv) {
        Transaction tr = this.hSession.getTransaction();
        try {
            tr.begin();
            this.hSession.persist(nv);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
    }

    public NhanVien findById(int nv) {
        return this.hSession.find(NhanVien.class, nv);
    }
}
