package entities;


import jakarta.persistence.*;


@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public HoaDon(Integer id, String idNV, String idKH, String ngayMua, int trangThai) {
        this.id = id;
        this.idNV = idNV;
        this.idKH = idKH;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai;
    }
}
