package controller;

import entities.MauSac;
import entities.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/nhan_vien/create",
        "/nhan_vien/store",
        "/nhan_vien/edit",
        "/nhan_vien/update",
        "/nhan_vien/delete",
        "/nhan_vien/index",
})
public class NhanVienServlet extends HttpServlet {
    List<NhanVien> dsNV = new ArrayList<>();

    public NhanVienServlet() {
        this.dsNV.add(new NhanVien(null, "A", "PH01", "Ax", "1234", 1));
        this.dsNV.add(new NhanVien(null, "B", "PH02", "Bx", "1234", 1));
        this.dsNV.add(new NhanVien(null, "C", "PH03", "Cx", "1234", 0));
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
        request.setAttribute("data", this.dsNV);
        request.getRequestDispatcher("/views/nhan_vien/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/nhan_vien/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String tenDN = request.getParameter("tenDN");
        String MK = request.getParameter("MK");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        NhanVien nv = new NhanVien(null, ten, ma, tenDN, MK, trangThai);
        this.dsNV.add(nv);
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsNV.size(); i++) {
            NhanVien nv = this.dsNV.get(i);
            if (nv.getma().equals(ma)) {
                request.setAttribute("nv", nv);
            }
        }
        request.getRequestDispatcher("/views/nhan_vien/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String tenDN = request.getParameter("tenDN");
        String MK = request.getParameter("MK");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        NhanVien nv = new NhanVien(null,ten, ma, tenDN, MK, trangThai);
        for (int i = 0; i < this.dsNV.size(); i++) {
            NhanVien nhanVien = this.dsNV.get(i);
            if (nhanVien.getma().equals(ma)) {
                this.dsNV.set(i, nv);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsNV.size(); i++) {
            NhanVien nv = this.dsNV.get(i);
            if (nv.getma().equals(ma)) {
                this.dsNV.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }
}
