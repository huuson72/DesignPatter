package com.nvtrung.baikiemtraso1.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nvtrung.baikiemtraso1.model.SinhVien;
import com.nvtrung.baikiemtraso1.service.NguonDuLieu;

public class NguonDuLieuSqlServer implements NguonDuLieu {
    private String chuoiKetNoi;
    private Connection connection;

    private static NguonDuLieuSqlServer instance;

    public NguonDuLieuSqlServer(String cnnst) {
        this.chuoiKetNoi = cnnst;
        try {
            this.connection = DriverManager.getConnection(chuoiKetNoi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static NguonDuLieuSqlServer getInstance(String cnnst) {
        if (instance == null) {
            instance = new NguonDuLieuSqlServer(cnnst);
        }
        return instance;
    }

    @Override
    public List<SinhVien> selectAll() {
        List<SinhVien> danhSachSinhVien = new ArrayList<>();
        String query = "SELECT * FROM SinhVien";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String maSinhVien = resultSet.getString("MaSV");
                String hoTen = resultSet.getString("HoTen");
                boolean gioiTinhNam = resultSet.getBoolean("GioiTinh");
                Date ngaySinh = resultSet.getDate("NgaySinh");
                SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, gioiTinhNam, ngaySinh);
                danhSachSinhVien.add(sinhVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachSinhVien;
    }

    @Override
    public void insert(SinhVien sv) {
        String query = "INSERT INTO SinhVien (MaSV, HoTen, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, sv.getMaSinhVien());
            preparedStatement.setString(2, sv.getHoTen());
            preparedStatement.setBoolean(3, sv.isGioiTinhNam());
            preparedStatement.setDate(4, new java.sql.Date(sv.getNgaySinh().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSinhVien) {
        String query = "DELETE FROM SinhVien WHERE MaSV = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maSinhVien);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
