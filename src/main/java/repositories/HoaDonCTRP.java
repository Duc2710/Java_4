package repositories;

import entities.HoaDonCT;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class HoaDonCTRP {
    private Session hSession = HibernateUtil.getFACTORY().openSession();
    public List<HoaDonCT> findAll(){
        String hql = "Select entity from HoaDonCT entity";
        Query q = hSession.createQuery(hql, HoaDonCT.class);
        return q.getResultList();
    }
    public void create(HoaDonCT hdct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.persist(hdct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }

    }
    public void update(HoaDonCT hdct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.merge(hdct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public void delete(HoaDonCT hdct){
        Transaction tr = this.hSession.getTransaction();
        try{
            tr.begin();
            this.hSession.remove(hdct);
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
    public HoaDonCT findById(int hdct){
        return this.hSession.find(HoaDonCT.class, hdct);
    }
}
