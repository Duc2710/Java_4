package controller;

import entities.MauSac;
import entities.SanPham;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SanPhamRP;

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
    private SanPhamRP spRP = new SanPhamRP();

    public SanPhamServlet() {
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
        request.setAttribute("data", spRP.findAll());
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
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.spRP.create(sp);
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sp = this.spRP.findById(id);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/views/san_pham/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        SanPham sp = new SanPham();
        try {
            BeanUtils.populate(sp, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.spRP.update(sp);
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sp = this.spRP.findById(id);
        this.spRP.delete(sp);
        response.sendRedirect("/BTVN_war_exploded/san_pham/index");
    }
}


