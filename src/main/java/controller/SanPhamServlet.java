package controller;

import entities.MauSac;
import entities.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/san_pham/create",
        "/san_pham/store",
        "/san_pham/edit",
        "/san_pham/update",
        "/san_pham/delete",
        "/san_pham/index"
})
public class SanPhamServlet extends HttpServlet {
    List<SanPham> dsSP = new ArrayList<>();
    public  SanPhamServlet(){
        this.dsSP.add(new SanPham(null, "012", "tivi",1 ));
        this.dsSP.add(new SanPham(null, "013", "PC",1 ));
        this.dsSP.add(new SanPham(null, "014", "Laptop",0 ));
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
        request.setAttribute("data", this.dsSP);
        request.getRequestDispatcher("/views/san_pham/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/san_pham/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        SanPham sp = new SanPham(null, ma, ten, trangThai);
        this.dsSP.add(sp);
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsSP.size(); i++) {
            SanPham sp = this.dsSP.get(i);
            if (sp.getMa().equals(ma)) {
                request.setAttribute("sp", sp);
            }
        }
        request.getRequestDispatcher("/views/san_pham/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        SanPham sp = new SanPham(null, ma, ten, trangThai);
        for (int i = 0; i < this.dsSP.size(); i++) {
            SanPham sanPham = this.dsSP.get(i);
            if (sanPham.getMa().equals(ma)) {
                this.dsSP.set(i, sanPham);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsSP.size(); i++) {
            SanPham sanPham = this.dsSP.get(i);
            if (sanPham.getMa().equals(ma)) {
                this.dsSP.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }
}


