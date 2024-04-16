package controller;

import entities.HoaDon;
import entities.HoaDonCT;
import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.HoaDonCTRP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/hoa_don_CT/create",
        "/hoa_don_CT/store",
        "/hoa_don_CT/edit",
        "/hoa_don_CT/update",
        "/hoa_don_CT/delete",
        "/hoa_don_CT/index",
})
public class HoaDonCTServlet extends HttpServlet {
    //    List<HoaDonCT> dsHD = new ArrayList<>();
    private HoaDonCTRP hdctRP = new HoaDonCTRP();

    public HoaDonCTServlet() {
//        this.dsHD.add(new HoaDonCT(null, "A01", "Z01",10 ,1000 , 1));
//        this.dsHD.add(new HoaDonCT(null, "B01", "Z02",20 ,1000 , 1));
//        this.dsHD.add(new HoaDonCT(null, "C01", "Z03",30 ,1000 , 0));
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
        request.setAttribute("data", hdctRP.findAll());
        request.getRequestDispatcher("/views/hoa_don_CT/index.jsp")
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
        HoaDonCT hdct = new HoaDonCT();
        try {
            BeanUtils.populate(hdct, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hdctRP.create(hdct);
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDonCT hdct = this.hdctRP.findById(id);
        request.setAttribute("hdct", hdct);
        request.getRequestDispatcher("/views/hoa_don_CT/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        HoaDonCT hdct = new HoaDonCT();
        try {
            BeanUtils.populate(hdct, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.hdctRP.update(hdct);
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDonCT hdct = this.hdctRP.findById(id);
        this.hdctRP.delete(hdct);
        response.sendRedirect("/BTVN_war_exploded/hoa_don_CT/index");
    }
}