package controller;

import entities.KhachHang;
import entities.MauSac;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.KhachHangRP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/khach_hang/create",
        "/khach_hang/store",
        "/khach_hang/edit",
        "/khach_hang/update",
        "/khach_hang/delete",
        "/khach_hang/index",
})
public class KhachHangServlet extends HttpServlet {
//    List<KhachHang> dsKH = new ArrayList<>();

    private KhachHangRP khRP = new KhachHangRP();
    public KhachHangServlet() {
//        this.dsKH.add(new KhachHang(null, "001", "01234", "TH01", 1));
//        this.dsKH.add(new KhachHang(null, "002", "12312", "TH02", 1));
//        this.dsKH.add(new KhachHang(null, "003", "01231", "TH01", 0));
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
        request.setAttribute("data", khRP.findAll());
        request.getRequestDispatcher("/views/khach_hang/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
//        String ten = request.getParameter("ten");
//        String SDT = request.getParameter("SDT");
//        String ma = request.getParameter("ma");
//        String ttString = request.getParameter("trangThai");
//        int trangThai = Integer.parseInt(ttString);
//        KhachHang kh = new KhachHang(null, ten, SDT, ma, trangThai);
//        this.khRP.create(kh);
        KhachHang kh = new KhachHang();
        try{
            BeanUtils.populate(kh, request.getParameterMap());
        }catch(Exception e){
            e.printStackTrace();
        }
        this.khRP.create(kh);
        response.sendRedirect("/BTVN_war_exploded/khach_hang/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
//        String ma = request.getParameter("ma");
//        for (int i = 0; i < this.khRP.findAll(); i++) {
//            KhachHang kh = this.khRP.findAll().get(i);
//            if (kh.getMa().equals(ma)) {
//                request.setAttribute("kh", kh);
//            }
//        }
        int ID = Integer.parseInt(request.getParameter("ID"));
        KhachHang kh = this.khRP.findById(ID);
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/views/khach_hang/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
//        String ten = request.getParameter("ten");
//        String SDT = request.getParameter("SDT");
//        String ma = request.getParameter("ma");
//        String ttString = request.getParameter("trangThai");
//        int trangThai = Integer.parseInt(ttString);
//        KhachHang kh = new KhachHang(null, ten, SDT, ma, trangThai);
//        for (int i = 0; i < this.khRP.findAll().size(); i++) {
//            KhachHang color = this.khRP.findAll().get(i);
//            if (color.getMa().equals(ma)) {
//                this.dsKH.set(i, kh);
//            }
//        }
        KhachHang kh = new KhachHang();
        try{
            BeanUtils.populate(kh, request.getParameterMap());
        }catch(Exception e){
            e.printStackTrace();
        }
        this.khRP.update(kh);
        response.sendRedirect("/BTVN_war_exploded/khach_hang/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
//        String ma = request.getParameter("ma");
//        for (int i = 0; i < this.dsKH.size(); i++) {
//            KhachHang kh = this.dsKH.get(i);
//            if (kh.getMa().equals(ma)) {
//                this.dsKH.remove(i);
//            }
//        }
        int ID = Integer.parseInt(request.getParameter("ID"));
        KhachHang kh = this.khRP.findById(ID);
        this.khRP.delete(kh);
        response.sendRedirect("/BTVN_war_exploded/khach_hang/index");
    }
}