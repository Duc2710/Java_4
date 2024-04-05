package repositories;

import entities.KhachHang;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

//import javax.management.Query;
import java.util.List;

public class KhachHangRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<KhachHang> findAll(){
        String hql = "Select entity from KhachHang entity";
        Query q = hSession.createQuery(hql, KhachHang.class);
        return q.getResultList();
    }
    public void create(KhachHang sp){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.persist(sp);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }

    }public void update(KhachHang sp){
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
    public void delete(KhachHang sp){
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
    public KhachHang findById(int sp){
        return this.hSession.find(KhachHang.class, sp);
    }
}
