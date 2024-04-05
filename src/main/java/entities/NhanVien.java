package entities;

import jakarta.persistence.*;

@Table(name = "NhanVien")
@Entity
public class NhanVien {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Integer ID;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "TenDangNhap")
    private String tenDN;
    @Column(name = "MatKhau")
    private String MK;
    @Column(name = "TrangThai")
    private int trangThai;

    public NhanVien() {
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

    public String getMa() {
        return ma;
    }

    public void setma(String ma) {
        this.ma = ma;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMK() {
        return MK;
    }

    public void getMK(String MK) {
        this.MK = MK;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien(Integer ID, String ten, String ma, String tenDN, String MK, int trangThai) {
        this.ID = ID;
        this.ten = ten;
        this.ma = ma;
        this.tenDN = tenDN;
        this.MK = MK;
        this.trangThai = trangThai;
    }
}
