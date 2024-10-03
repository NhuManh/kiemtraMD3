package org.example;

import org.example.MatBangDAO;
import org.example.MatBang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MatBangServlet extends HttpServlet {
    private MatBangDAO matBangDAO;

    @Override
    public void init() {
        matBangDAO = new MatBangDAO(); // Khởi tạo DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Mặc định hiển thị danh sách
        }

        switch (action) {
            case "list":
                listMatBang(request, response);
                break;
            case "delete":
                deleteMatBang(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listMatBang(request, response);
                break;
        }
    }

    private void listMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<MatBang> listMatBang = matBangDAO.getAllMatBangSortedByDienTich();
            request.setAttribute("listMatBang", listMatBang);
            RequestDispatcher dispatcher = request.getRequestDispatcher("student_list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving data: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            matBangDAO.deleteMatBang(id);
            response.sendRedirect("MatBangServlet?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while deleting data: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_matbang.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            MatBang existingMatBang = matBangDAO.getMatBangById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit_matbang.jsp");
            request.setAttribute("matBang", existingMatBang);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while retrieving data: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            addMatBang(request, response);
        } else if ("update".equals(action)) {
            updateMatBang(request, response);
        }
    }

    private void addMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ form
        String maMatBang = request.getParameter("maMatBang");
        String trangThai = request.getParameter("trangThai");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        String loaiMatBang = request.getParameter("loaiMatBang");
        double giaTien = Double.parseDouble(request.getParameter("giaTien"));
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");

        MatBang newMatBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);

        try {
            matBangDAO.addMatBang(newMatBang);
            response.sendRedirect("MatBangServlet?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while adding data: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Tương tự như addMatBang
        // Cần xử lý logic cập nhật mặt bằng
    }
}
