package controller;

import entities.MauSac;
import entities.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.NhanVienRP;

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
    private NhanVienRP nvRP = new NhanVienRP();

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
        request.setAttribute("data", nvRP.findAll());
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
        NhanVien nv = new NhanVien();
        try{
            BeanUtils.populate(nv, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.nvRP.create(nv);
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        NhanVien nv = this.nvRP.findById(ID);
        request.setAttribute("nv", nv);
        request.getRequestDispatcher("/views/nhan_vien/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        NhanVien nv = new NhanVien();
        try{
            BeanUtils.populate(nv, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.nvRP.update(nv);
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        NhanVien nv = this.nvRP.findById(ID);
        this.nvRP.delete(nv);
        response.sendRedirect("/BTVN_war_exploded/nhan_vien/index");
    }
}
