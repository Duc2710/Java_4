package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Table(name = "KhachHang")
@Entity
public class KhachHang {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TrangThai")
    private Integer trangThai;

    public KhachHang() {
    }

    public KhachHang(Integer ID, String ten, String SDT, String ma, Integer trangThai) {
        this.ID = ID;
        this.ten = ten;
        this.SDT = SDT;
        this.ma = ma;
        this.trangThai = trangThai;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
