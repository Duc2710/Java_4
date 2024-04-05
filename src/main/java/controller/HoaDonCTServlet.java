package controller;

import entities.HoaDon;
import entities.HoaDonCT;
import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/hoa_don_CT/create",
        "/hoa_don_CT/store",
        "/hoa_don_CT/edit",
        "/hoa_don_CT/update",
        "/hoa_don_CT/delete",
        "/hoa_don_CT/hoaDonCT",
})
public class HoaDonCTServlet extends HttpServlet {
    List<HoaDonCT> dsHD = new ArrayList<>();
    public HoaDonCTServlet(){
        this.dsHD.add(new HoaDonCT(null, "A01", "Z01",10 ,1000 , 1));
        this.dsHD.add(new HoaDonCT(null, "B01", "Z02",20 ,1000 , 1));
        this.dsHD.add(new HoaDonCT(null, "C01", "Z03",30 ,1000 , 0));
    }
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    public void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("data", this.dsHD);
        request.getRequestDispatcher("/views/hoa_don_CT/hoaDonCT.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/hoa_don_CT/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idHD = request.getParameter("idHD");
        String idSPCT = request.getParameter("idSPCT");
        String SL = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(SL);
        String DG = request.getParameter("donGia");
        int donGia = Integer.parseInt(DG);
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        HoaDonCT hdct = new HoaDonCT(null, idHD, idSPCT, soLuong, donGia ,trangThai);
        this.dsHD.add(hdct);
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/hoaDonCT");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idHD = request.getParameter("idHD");
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDonCT hdct = this.dsHD.get(i);
            if (hdct.getIdHD().equals(idHD)) {
                request.setAttribute("idHD", hdct);
            }
        }
        request.getRequestDispatcher("/views/hoa_don_CT/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idHD = request.getParameter("idHD");
        String idSPCT = request.getParameter("idSPCT");
        String SL = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(SL);
        String DG = request.getParameter("donGia");
        int donGia = Integer.parseInt(DG);
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        HoaDonCT hdct = new HoaDonCT(null, idHD, idSPCT, soLuong, donGia ,trangThai);
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDonCT color = this.dsHD.get(i);
            if (color.getIdHD().equals(idHD)) {
                this.dsHD.set(i, hdct);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/hoaDonCT");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idHD = request.getParameter("idHD");
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDonCT hdct = this.dsHD.get(i);
            if (hdct.getIdHD().equals(idHD)) {
                this.dsHD.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/hoaDonCT");
    }
}