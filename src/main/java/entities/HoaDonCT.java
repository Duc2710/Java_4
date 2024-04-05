package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonCT {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "IdHoaDon")
    private String idHD;
    @Column(name = "IdSPCT")
    private String idSPCT;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private int donGia;
    @Column(name = "TrangThai")
    private int trangThai;
//    @Column(name = "ThoiGian")
//    private DateTime

    public HoaDonCT() {
    }

    public HoaDonCT(Integer ID, String idHD, String idSPCT, int soLuong, int donGia, int trangThai) {
        this.ID = ID;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        this.idHD = idHD;
    }

    public String getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(String idSPCT) {
        this.idSPCT = idSPCT;
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
}
