package controller;

import entities.KhachHang;
import entities.SPChiTiet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/san_pham_CT/create",
        "/san_pham_CT/store",
        "/san_pham_CT/edit",
        "/san_pham_CT/update",
        "/san_pham_CT/delete",
        "/san_pham_CT/index",
})
public class SPCTServlet extends HttpServlet {
    List<SPChiTiet> dsSPCT = new ArrayList<>();
    public SPCTServlet(){
        this.dsSPCT.add(new SPChiTiet(null, "001", "axz", "a12", "012", 10, 1000, 1));
        this.dsSPCT.add(new SPChiTiet(null, "002", "ayz", "a23", "013", 11, 1000, 0));
        this.dsSPCT.add(new SPChiTiet(null, "003", "azz", "a34", "014", 12, 1000, 1));
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
        request.setAttribute("data", this.dsSPCT);
        request.getRequestDispatcher("/views/san_pham_CT/index.jsp")
                .forward(request, response);
    }

    public void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        request.getRequestDispatcher("/views/san_pham_CT/create.jsp")
                .forward(request, response);
    }

    public void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String idKT = request.getParameter("idKT");
        String idMS = request.getParameter("idMS");
        String idSP = request.getParameter("idSP");
        String SL = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(SL);
        String DG = request.getParameter("donGia");
        int donGia = Integer.parseInt(DG);
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        SPChiTiet spct = new SPChiTiet(null, ma, idKT, idMS, idSP, soLuong, donGia, trangThai);
        this.dsSPCT.add(spct);
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsSPCT.size(); i++) {
            SPChiTiet spct = this.dsSPCT.get(i);
            if (spct.getMa().equals(ma)) {
                request.setAttribute("spct", spct);
            }
        }
        request.getRequestDispatcher("/views/san_pham_CT/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String idKT = request.getParameter("idKT");
        String idMS = request.getParameter("idMS");
        String idSP = request.getParameter("idSP");
        String SL = request.getParameter("soLuong");
        int soLuong = Integer.parseInt(SL);
        String DG = request.getParameter("donGia");
        int donGia = Integer.parseInt(DG);
        String ttString = request.getParameter("trangThai");
        int trangThai = Integer.parseInt(ttString);
        SPChiTiet spct = new SPChiTiet(null, ma, idKT, idMS, idSP, soLuong, donGia, trangThai);
        for (int i = 0; i < this.dsSPCT.size(); i++) {
            SPChiTiet SPCT = this.dsSPCT.get(i);
            if (SPCT.getMa().equals(ma)) {
                this.dsSPCT.set(i, spct);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        for (int i = 0; i < this.dsSPCT.size(); i++) {
            SPChiTiet spct = this.dsSPCT.get(i);
            if (spct.getMa().equals(ma)) {
                this.dsSPCT.remove(i);
            }
        }
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }
}
