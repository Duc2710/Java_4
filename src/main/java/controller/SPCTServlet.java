package controller;

import entities.KhachHang;
import entities.SPChiTiet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import repositories.SPCTRP;

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
    private SPCTRP spctrp = new SPCTRP();


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
        request.setAttribute("data", spctrp.findAll());
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
        SPChiTiet spct = new SPChiTiet();
        try{
            BeanUtils.populate(spct, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.spctrp.create(spct);
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }

    public void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        SPChiTiet spct = this.spctrp.findById(id);
        request.setAttribute("spct", spct);
        request.getRequestDispatcher("/views/san_pham_CT/edit.jsp")
                .forward(request, response);
    }

    public void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        SPChiTiet spct = new SPChiTiet();
        try{
            BeanUtils.populate(spct, request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        this.spctrp.update(spct);
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }

    public void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        SPChiTiet spct = this.spctrp.findById(id);
        this.spctrp.delete(spct);
        response.sendRedirect("/BTVN_war_exploded/san_pham_CT/index");
    }
}
