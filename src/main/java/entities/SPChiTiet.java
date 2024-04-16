package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "SanPhamChiTiet")
public class SPChiTiet {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "MaSPCT")
    private String ma;
    @Column(name = "IdKichThuoc")
    private String idKT;
    @Column(name = "IdMauSac")
    private String idMS;
    @Column(name = "IdSanPham")
    private String idSP;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private int donGia;
    @Column(name = "TrangThai")
    private int trangThai;

    public SPChiTiet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getIdKT() {
        return idKT;
    }

    public void setIdKT(String idKT) {
        this.idKT = idKT;
    }

    public String getIdMS() {
        return idMS;
    }

    public void setIdMS(String idMS) {
        this.idMS = idMS;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public SPChiTiet(Integer id, String ma, String idKT, String idMS, String idSP, int soLuong, int donGia, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.idKT = idKT;
        this.idMS = idMS;
        this.idSP = idSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SPChiTiet{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", idKT='" + idKT + '\'' +
                ", idMS='" + idMS + '\'' +
                ", idSP='" + idSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", trangThai=" + trangThai +
                '}';
    }
}
