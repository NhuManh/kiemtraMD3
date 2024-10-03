package org.example;

import org.example.MatBang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatBangDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Nhudinhmanh2004@";

    private Connection jdbcConnection;

    public MatBangDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        return jdbcConnection;
    }

    public List<MatBang> getAllMatBangSortedByDienTich() throws SQLException {
        List<MatBang> listMatBang = new ArrayList<>();
        String sql = "SELECT * FROM matbang ORDER BY dienTich"; // Cập nhật tên bảng và cột nếu cần

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maMatBang = resultSet.getString("maMatBang");
                String trangThai = resultSet.getString("trangThai");
                double dienTich = resultSet.getDouble("dienTich");
                int tang = resultSet.getInt("tang");
                String loaiMatBang = resultSet.getString("loaiMatBang");
                double giaTien = resultSet.getDouble("giaTien");
                String ngayBatDau = resultSet.getString("ngayBatDau");
                String ngayKetThuc = resultSet.getString("ngayKetThuc");

                MatBang matBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);
                listMatBang.add(matBang);
            }
        }
        return listMatBang;
    }

    public void addMatBang(MatBang matBang) throws SQLException {
        String sql = "INSERT INTO matbang (maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, matBang.getMaMatBang());
            statement.setString(2, matBang.getTrangThai());
            statement.setDouble(3, matBang.getDienTich());
            statement.setInt(4, matBang.getTang());
            statement.setString(5, matBang.getLoaiMatBang());
            statement.setDouble(6, matBang.getGiaTien());
            statement.setString(7, String.valueOf(matBang.getNgayBatDau()));
            statement.setString(8, String.valueOf(matBang.getNgayKetThuc()));

            statement.executeUpdate();
        }
    }

    public MatBang getMatBangById(int id) throws SQLException {
        MatBang matBang = null;
        String sql = "SELECT * FROM matbang WHERE id = ?"; // Cập nhật theo cấu trúc bảng của bạn

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maMatBang = resultSet.getString("maMatBang");
                String trangThai = resultSet.getString("trangThai");
                double dienTich = resultSet.getDouble("dienTich");
                int tang = resultSet.getInt("tang");
                String loaiMatBang = resultSet.getString("loaiMatBang");
                double giaTien = resultSet.getDouble("giaTien");
                String ngayBatDau = resultSet.getString("ngayBatDau");
                String ngayKetThuc = resultSet.getString("ngayKetThuc");

                matBang = new MatBang(maMatBang, trangThai, dienTich, tang, loaiMatBang, giaTien, ngayBatDau, ngayKetThuc);
            }
        }
        return matBang;
    }

    public void deleteMatBang(int id) throws SQLException {
        String sql = "DELETE FROM matbang WHERE id = ?";

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
