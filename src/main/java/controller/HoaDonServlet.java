package controller;

import entities.HoaDon;
import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.HoaDonRP;

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
    private HoaDonRP hdRP = new HoaDonRP();
    public HoaDonServlet(){
//        this.dsHD.add(new HoaDon(null, "A", "Z", "23/12/2024",1));
//        this.dsHD.add(new HoaDon(null, "B", "X", "23/12/2024",0));
//        this.dsHD.add(new HoaDon(null, "C", "Y", "24/12/2024",1));
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
            this.hoaDonCT(request, response);
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

    public void hoaDonCT(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.setAttribute("data", hdRP.findAll());
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
//        String idNV = request.getParameter("idNV");
//        String idKH = request.getParameter("idKH");
//        String ngayMua = request.getParameter("ngayMua");
//        String ttString = request.getParameter("trangThai");
//        int trangThai = Integer.parseInt(ttString);
        HoaDon hd = new HoaDon();
        try{
            BeanUtils.populate(hd, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.hdRP.create(hd);
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        HoaDon hd = this.hdRP.findById(ID);
        request.setAttribute("hd", hd);
        request.getRequestDispatcher("/views/hoa_don/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
//        String idNV = request.getParameter("idNV");
//        String idKH = request.getParameter("idKH");
//        String ngayMua = request.getParameter("ngayMua");
//        String ttString = request.getParameter("trangThai");
//        int trangThai = Integer.parseInt(ttString);
        HoaDon hd = new HoaDon();
        try{
            BeanUtils.populate(hd, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.hdRP.update(hd);
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        HoaDon hd = this.hdRP.findById(ID);
        this.hdRP.delete(hd);
        response.sendRedirect("/BTVN_war_exploded/hoa_don/index");
    }
}
