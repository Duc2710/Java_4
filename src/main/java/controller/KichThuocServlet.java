package controller;

import entities.KichThuoc;
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
        "/kich_thuoc/kichThuocCreate",
        "/kich_thuoc/store",
        "/kich_thuoc/edit",
        "/kich_thuoc/update",
        "/kich_thuoc/delete",
        "/kich_thuoc/index",
})
public class KichThuocServlet extends HttpServlet {
    List<KichThuoc> dsKT = new ArrayList<>();

    public KichThuocServlet() {
        this.dsKT.add(new KichThuoc(null, "01", "001", 1));
        this.dsKT.add(new KichThuoc(null, "02", "002", 0));
        this.dsKT.add(new KichThuoc(null, "03", "003", 1));
    }

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.contains("kichThuocCreate")) {
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
        request.setAttribute("data", this.dsKT);
        request.getRequestDispatcher("/views/kich_thuoc/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/kich_thuoc/kichThuocCreate.jsp")
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
        KichThuoc kt = new KichThuoc(null, ma, ten, trangThai);
        this.dsKT.add(kt);
        response.sendRedirect("/BTVN_war_exploded/kich_thuoc/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsKT.size(); i++) {
            KichThuoc kt = this.dsKT.get(i);
            if (kt.getMa().equals(ma)) {
                request.setAttribute("kt", kt);
            }
        }
        request.getRequestDispatcher("/views/kich_thuoc/edit.jsp")
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
        KichThuoc kt = new KichThuoc(null, ma, ten, trangThai);
        for (int i = 0; i < this.dsKT.size(); i++) {
            KichThuoc color = this.dsKT.get(i);
            if (color.getMa().equals(ma)) {
                this.dsKT.set(i, kt);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/kich_thuoc/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsKT.size(); i++) {
            KichThuoc color = this.dsKT.get(i);
            if (color.getMa().equals(ma)) {
                this.dsKT.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/kich_thuoc/index");
    }
}
