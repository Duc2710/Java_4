package repositories;

import entities.SanPham;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class SanPhamRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<SanPham> findAll(){
        String hql = "Select entity from SanPham entity";
        Query q = hSession.createQuery(hql, SanPham.class);
        return q.getResultList();
    }
    public void create(SanPham sp){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.persist(sp);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }

    }public void update(SanPham sp){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.merge(sp);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public void delete(SanPham sp){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.remove(sp);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public SanPham findById(int sp){
        return this.hSession.find(SanPham.class, sp);
    }
}
