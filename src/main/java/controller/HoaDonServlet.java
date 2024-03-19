package controller;

import entities.HoaDon;
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
        "/hoa_don/create",
        "/hoa_don/store",
        "/hoa_don/edit",
        "/hoa_don/update",
        "/hoa_don/delete",
        "/hoa_don/index",
})
public class HoaDonServlet extends HttpServlet {
    List<HoaDon> dsHD = new ArrayList<>();
    public HoaDonServlet(){
        this.dsHD.add(new HoaDon(null, "A", "Z", "23/12/2024",1));
        this.dsHD.add(new HoaDon(null, "B", "X", "23/12/2024",0));
        this.dsHD.add(new HoaDon(null, "C", "Y", "24/12/2024",1));
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
        request.getRequestDispatcher("/views/hoa_don/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/hoa_don/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idNV = request.getParameter("idNV");
        String idKH = request.getParameter("idKH");
        String ngayMua = request.getParameter("ngayMua");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        HoaDon hd = new HoaDon(null, idNV, idKH, ngayMua, trangThai);
        this.dsHD.add(hd);
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idKH = request.getParameter("idKH");
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDon hd = this.dsHD.get(i);
            if (hd.getIdKH().equals(idKH)) {
                request.setAttribute("hd", hd);
            }
        }
        request.getRequestDispatcher("/views/hoa_don/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idNV = request.getParameter("idNV");
        String idKH = request.getParameter("idKH");
        String ngayMua = request.getParameter("ngayMua");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        HoaDon hd = new HoaDon(null, idNV, idKH, ngayMua, trangThai);
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDon hoaDon = this.dsHD.get(i);
            if (hoaDon.getIdKH().equals(idKH)) {
                this.dsHD.set(i, hd);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String idKH = request.getParameter("idKH");
        for (int i = 0; i < this.dsHD.size(); i++) {
            HoaDon hd = this.dsHD.get(i);
            if (hd.getIdKH().equals(idKH)) {
                this.dsHD.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }
}
