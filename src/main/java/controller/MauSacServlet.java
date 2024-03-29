package controller;

import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.MauSacRP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/mau_sac/create",  // GET
        "/mau_sac/store",   // POST
        "/mau_sac/edit",    // GET
        "/mau_sac/update",  // POST
        "/mau_sac/delete",  // GET
        "/mau_sac/index",   // GET
})
public class MauSacServlet extends HttpServlet {
    List<MauSac> ds = new ArrayList<>();
    private MauSacRP msRP = new MauSacRP();
    public MauSacServlet() {
        //
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
        request.setAttribute("data", msRP.findAll());
        request.getRequestDispatcher("/views/mau_sac/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/mau_sac/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String id = request.getParameter("ID");
        int ID = Integer.parseInt(id);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        MauSac ms = new MauSac(ID, ma, ten, trangThai);
        this.msRP.create(ms);
        response.sendRedirect("/BTVN_war_exploded/mau_sac/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.msRP.findAll().size(); i++) {
            MauSac ms = this.msRP.findAll().get(i);
            if (ms.getMa().equals(ma)) {
                request.setAttribute("ms", ms);
            }
        }
        request.getRequestDispatcher("/views/mau_sac/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String id = request.getParameter("ID");
        int ID = Integer.parseInt(id);
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        MauSac ms = new MauSac(ID, ma, ten, trangThai);
        for (int i = 0; i < this.msRP.findAll().size(); i++) {
            MauSac color = this.msRP.findAll().get(i);
            if (color.getMa().equals(ma)) {
                this.msRP.update(ms);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/mau_sac/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.msRP.findAll().size(); i++) {
            MauSac color = this.msRP.findAll().get(i);
            if (color.getMa().equals(ma)) {
                this.msRP.delete(color);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/mau_sac/index");
    }
}