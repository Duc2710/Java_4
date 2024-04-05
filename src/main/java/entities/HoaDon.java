package entities;

//import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "IdNV")
    private String idNV;
    @Column(name = "IdKH")
    private String idKH;
    @Column(name = "NgayMuaHang")
    private String ngayMua;
    @Column(name = "TrangThai")
    private  int trangThai;

    public HoaDon() {
    }

    public HoaDon(Integer ID, String idNV, String idKH, String ngayMua, int trangThai) {
        this.ID = ID;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
