package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonCT {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "IdHoaDon")
    private String idHD;
    @Column(name = "IdSPCT")
    private String idSPCT;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private int donGia;
    @Column(name = "ThoiGian")
    private String thoiGian;
    @Column(name = "TrangThai")
    private int trangThai;

    public HoaDonCT() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public HoaDonCT(Integer id, String idHD, String idSPCT, int soLuong, int donGia, String thoiGian, int trangThai) {
        this.id = id;
        this.idHD = idHD;
        this.idSPCT = idSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thoiGian = thoiGian;
        this.trangThai = trangThai;
    }
}
