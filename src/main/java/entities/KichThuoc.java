package entities;

public class KichThuoc {
    private Integer id;
    private String ten;
    private String ma;
    private int trangThai;

    public KichThuoc() {
    }

    public KichThuoc(Integer id, String ten, String ma, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
