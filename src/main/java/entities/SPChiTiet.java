package entities;

public class SPChiTiet {
    private Integer ID;
    private String ma;
    private String idKT;
    private String idMS;
    private String idSP;
    private int soLuong;
    private int donGia;
    private int trangThai;

    public SPChiTiet() {
    }

    public SPChiTiet(Integer ID, String ma, String idKT, String idMS, String idSP, int soLuong, int donGia, int trangThai) {
        this.ID = ID;
        this.ma = ma;
        this.idKT = idKT;
        this.idMS = idMS;
        this.idSP = idSP;
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
}
