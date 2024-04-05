package repositories;

import entities.SPChiTiet;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class SPCTRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<SPChiTiet> findAll(){
        String hql = "Select entity from SPChiTiet entity";
        Query q = hSession.createQuery(hql, SPChiTiet.class);
        return q.getResultList();
    }
    public void create(SPChiTiet spct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.persist(spct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }

    }public void update(SPChiTiet spct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.merge(spct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public void delete(SPChiTiet spct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.remove(spct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public SPChiTiet findById(int spct){
        return this.hSession.find(SPChiTiet.class, spct);
    }

    public static void main(String[] args) {
        System.out.println(new SPCTRP().findAll().toString());
    }
}
